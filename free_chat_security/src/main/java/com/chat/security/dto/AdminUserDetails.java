package com.chat.security.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.model.UmsPermission;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 * Created by macro on 2018/4/26.
 */
@Data
@NoArgsConstructor
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionList;
    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
    }
    @JSONField(serialize = false)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }
    @JSONField(serialize = false)
    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }
    @JSONField(serialize = false)
    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }
    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JSONField(serialize = false)
    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }

    @Override
    public String toString() {
        return "AdminUserDetails{" +
                "umsAdmin=" + umsAdmin +
                ", permissionList=" + permissionList +
                '}';
    }
}
