package com.chat.user.controller;


import com.chat.model.dto.XcUserExt;
import com.chat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/ucenter")
public class UcenterController {
    @Autowired
    UserService userService;

    @GetMapping("/getuser")
    public XcUserExt getUserext(@RequestParam("username") String username) {
        XcUserExt as = userService.getUserExt(username);
        return as;
    }
}
