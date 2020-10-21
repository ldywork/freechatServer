package com.chat.gateway.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chat.search.common.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class AuthService {
    @Value("${auth.tokenValiditySeconds}")
    int tokenValiditySeconds;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //从头取出jwt令牌
    public String getJwtFromHeader(HttpServletRequest request){
        //取出头信息
        String authorization = request.getHeader("Authorization");

//        request.getCoyoteRequest()
        if(StringUtils.isEmpty(authorization)){
            return null;
        }
        if(!authorization.startsWith("Bearer ")){
            return null;
        }
        //取到jwt令牌
        String jwt = authorization.substring(7);
        return jwt;


    }
    //从cookie取出token
    //查询身份令牌
    public String getTokenFromCookie(HttpServletRequest request){
        Map<String, String> cookieMap = CookieUtils.readCookie(request, "uid");
        String access_token = cookieMap.get("uid");
        if(StringUtils.isEmpty(access_token)){
            return null;
        }
        return access_token;
    }

    //查询令牌的有效期
     public long getExpire(String access_token){
        //key
         String key = "user_token:"+access_token;
         Long expire = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
         return expire;
     }
     /**
      * @Description:从redis中获取缓存
      * @Author: ldy
      * @Date: 2020/7/17 22:30
       * @param uid
      * @return: null
      **/
     public String getTokenFromRedisWithRefresh(String uid) {
         uid = "user_token:"+uid;
         String token =  stringRedisTemplate.opsForValue().get(uid);
         JSONObject obj= (JSONObject)JSON.parse(token);
         stringRedisTemplate.boundValueOps(uid).set(token,tokenValiditySeconds, TimeUnit.SECONDS);
         return obj.getString("jwt_token");
     }
}
