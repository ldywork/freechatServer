package com.chat.gateway.model;

import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.model.UmsPermission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * SpringSecurity需要的用户详情
 * Created by macro on 2018/4/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserDetails implements Serializable {

    private static final long serialVersionUID = 2008460335384924686L;
    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionList;


}
