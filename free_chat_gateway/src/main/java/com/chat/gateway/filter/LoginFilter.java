package com.chat.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chat.gateway.jwtutils.JwtTokenUtil;
import com.chat.gateway.model.AdminUserDetails;
import com.chat.gateway.service.AuthService;
import com.chat.model.dto.CommonCode;
import com.chat.model.dto.ResponseResult;
import com.chat.search.common.numutils.NumberKits;
import com.chat.search.common.redis.PersonalRedisUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 身份校验过虑器
 * @author Administrator
 * @version 1.0
 **/

@Component
public class LoginFilter extends ZuulFilter {

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${zuulfilter.dochainflag}")
    private String[] dochainflag;
    @Autowired
    private PersonalRedisUtil personalRedisUtil;
    @Value("${spring.redis.authprefix}")
    private String authprefix;
    @Value("${spring.redis.authtime}")
    private Integer authtime;
    //过虑器的类型
    @Override
    public String filterType() {
        /**
         pre：请求在被路由之前执行

         routing：在路由请求时调用

         post：在routing和errror过滤器之后调用

         error：处理请求时发生错误调用

         */
        return "pre";
    }

    //过虑器序号，越小越被优先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //返回true表示要执行此过虑器
        return true;
    }

    /**
     * @Method 在这里添加登录的验证,在注册和登录的请求时候自动放行否则需要验证请求头是否有token
     * @Author ldy
     * @Version  1.0
     * @Description
     * @Param 
     * @Return 
     * @Exception 
     * @Date 2021/1/18 17:28
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到request
        HttpServletRequest request = requestContext.getRequest();
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        //如果是登录和注册的请求,直接放行
        //获取uri,这个是去掉ip地址的路由
        String requestURI = request.getRequestURI();
        //检查每个uri的地址是否包含登录和注册的标识性路由,如果有那么不再校验
        String jwtFromHeader = authService.getJwtFromHeader(request);
        if (StringUtils.isNotBlank(jwtFromHeader)){
            //从token中获取用户名
            String username = jwtTokenUtil.getUserNameFromToken(jwtFromHeader);
            //根据用户名称从redis中获取用户的信息
            Object authMsgFromRedis = personalRedisUtil.get(authprefix + username);
            //如果redis中没有用户的信息那么说明登录信息过期直接返回null
            if (null == authMsgFromRedis ){
                //拒绝访问
                access_denied();
               return null;
            }
            //判断token是否失效,如果失效直接返回
            if(jwtTokenUtil.isTokenExpired(jwtFromHeader)){
                //拒绝访问
                access_denied();
                return null;
            }
            //以上均是有效的那么刷新redis和token的有效时间
            personalRedisUtil.set(authprefix + username, authMsgFromRedis,authtime);
            String refreshToken = jwtTokenUtil.refreshToken(jwtFromHeader);
            //将新的token发送给前端
            response.setHeader("Authorization","Bearer "+refreshToken);
            requestContext.addZuulRequestHeader("Authorization","Bearer "+jwtFromHeader);

        }else{
            //如果没有请求授权信息,且包含不需要验证的路由那么直接放行否则拒绝相应
            if (null != dochainflag && dochainflag.length > NumberKits.ZERO){
                for (String flag : dochainflag){
                    if ( requestURI.contains(flag)){
                        return null;
                    }
                }
            }
            //拒绝访问
            access_denied();
        }
        return null;


        //这个是加这ip地址的路由
//        StringBuffer requestURL = request.getRequestURL();
        //取cookie中的身份令牌
//        String tokenFromCookie = authService.getTokenFromCookie(request);
//        if(StringUtils.isEmpty(tokenFromCookie)){
//            //拒绝访问
//            access_denied();
//            return null;
//        }
        //从header中取jwt



//        //从redis取出jwt的过期时间
//        long expire = authService.getExpire(tokenFromCookie);
//        if(expire<0){
//            //拒绝访问
//            access_denied();
//            return null;
//        }
//        设置请求头,添加jwt信息
//        requestContext.addZuulRequestHeader("Authorization","Bearer "+authService.getTokenFromRedisWithRefresh(tokenFromCookie));

    }


    //拒绝访问
    private void access_denied(){
        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        //拒绝访问
        requestContext.setSendZuulResponse(false);
        //设置响应代码
        requestContext.setResponseStatusCode(200);
        //构建响应的信息
        ResponseResult responseResult = new ResponseResult(CommonCode.UNAUTHENTICATED);
        //转成json
        String jsonString = JSON.toJSONString(responseResult);
        requestContext.setResponseBody(jsonString);
        //转成json，设置contentType
        response.setContentType("application/json;charset=utf-8");
    }


}
