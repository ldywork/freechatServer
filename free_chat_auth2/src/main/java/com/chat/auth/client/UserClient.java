package com.chat.auth.client;


import com.chat.model.dto.XcUserExt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator.
 */
@FeignClient("free-chat-user")
public interface UserClient {
    //根据账号查询用户信息
    @GetMapping("/ucenter/getuser")
    public XcUserExt getUserext(@RequestParam("username") String username);
}
