package com.chat.security.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chat.backcontroll.api.CommonResult;
import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.model.UmsPermission;
import com.chat.search.common.redis.PersonalRedisUtil;
import com.chat.security.dto.AdminUserDetails;
import com.chat.security.feignapi.UmsAdminFeignClient;
import com.chat.security.feignapi.UmsAdminRoleRelationFeignClient;
import com.chat.security.service.UmsAdminService;
import com.chat.security.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * UmsAdminService实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${spring.redis.authtime}")
    private Integer authtime;
    @Value("${spring.redis.authprefix}")
    private String authprefix;
    @Autowired
    private UmsAdminFeignClient umsAdminFeignClient;
    @Autowired
    private UmsAdminRoleRelationFeignClient umsAdminRoleRelationFeignClient;
    @Autowired
    private PersonalRedisUtil personalRedisUtil;
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        List<UmsAdmin> adminList = umsAdminFeignClient.selectByExample(username);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        List<UmsAdmin> umsAdminList = umsAdminFeignClient.selectByExample(umsAdmin.getUsername());
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        umsAdminFeignClient.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            //这里是调用的SecurityConfig里边的方法来创建的这个接口的实现类型，这个loadByUserName就是那个方法里边的lambda表达式
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            //passwordEncoder这个东西也是从SecurityConfig里边创建的
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("验证失败");
            }
            //将用户的信息放到了SecurityContextImpl类的属性里边
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            //将用户的信息保存到redis
            personalRedisUtil.set(authprefix+username, JSONObject.toJSONString(userDetails),authtime);

        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }


    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        List<UmsPermission> permissionList = umsAdminRoleRelationFeignClient.getPermissionList(adminId);
        return permissionList;
    }

    @Override
    public CommonResult logout() {
        //获取当前登录的用户信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null == auth){
            return CommonResult.validateFailed("获取用户信息失败");
        }
        //获取用户的名称
        final String name = auth.getName();
        if (null == auth){
            return CommonResult.validateFailed("获取用户名称失败");
        }
        personalRedisUtil.del(authprefix+name);
        return CommonResult.success("退出成功");
    }
}
