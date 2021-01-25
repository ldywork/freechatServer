package com.shiro.learn.bean;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Permission implements Serializable {
    @ApiModelProperty(value = "id")
    private Long pid;

    @ApiModelProperty(value = "权限名称")
    private String permissionname;

    @ApiModelProperty(value = "权限编码")
    private String permissioncode;

    private static final long serialVersionUID = 1L;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public String getPermissioncode() {
        return permissioncode;
    }

    public void setPermissioncode(String permissioncode) {
        this.permissioncode = permissioncode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", permissionname=").append(permissionname);
        sb.append(", permissioncode=").append(permissioncode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}