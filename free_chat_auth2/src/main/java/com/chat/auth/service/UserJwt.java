package com.chat.auth.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
@ToString
public class UserJwt extends User {

    private String id;
    private String name;
    private String userpic;
    private String utype;
    private String companyId;
    // Collection<? extends GrantedAuthority> authorities就是权限信息
    public UserJwt(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

}
