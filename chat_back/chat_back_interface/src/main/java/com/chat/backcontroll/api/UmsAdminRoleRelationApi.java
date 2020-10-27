package com.chat.backcontroll.api;

import com.chat.backcontroll.model.UmsAdminRoleRelation;
import com.chat.backcontroll.model.UmsAdminRoleRelationExample;
import com.chat.backcontroll.model.UmsPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("/umsAdminRoleRelation")
public interface UmsAdminRoleRelationApi {
    @GetMapping("/countByExample")
    int countByExample(@RequestBody UmsAdminRoleRelationExample example);
    @GetMapping("/deleteByExample")
    int deleteByExample(@RequestBody UmsAdminRoleRelationExample example);
    @GetMapping("/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/insert")
    int insert(@RequestBody UmsAdminRoleRelation record);
    @GetMapping("/insertSelective")
    int insertSelective(@RequestBody UmsAdminRoleRelation record);
    @GetMapping("/selectByExample")
    List<UmsAdminRoleRelation> selectByExample(@RequestBody UmsAdminRoleRelationExample example);
    @GetMapping("/selectByPrimaryKey")
    UmsAdminRoleRelation selectByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("record") UmsAdminRoleRelation record, @RequestParam("example") UmsAdminRoleRelationExample example);
    @GetMapping("/updateByExample")
    int updateByExample(@RequestParam("record") UmsAdminRoleRelation record, @RequestParam("example") UmsAdminRoleRelationExample example);
    @GetMapping("/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UmsAdminRoleRelation record);
    @GetMapping("/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UmsAdminRoleRelation record);
    @GetMapping("/getPermissionList")
    List<UmsPermission> getPermissionList(@RequestParam("adminId") Long adminId);
}