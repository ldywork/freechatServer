package com.chat.backcontroll.api;

import com.chat.backcontroll.model.UmsAdminPermissionRelation;
import com.chat.backcontroll.model.UmsAdminPermissionRelationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UmsAdminPermissionRelationApi {
    @GetMapping("/countByExample")
    int countByExample(@RequestBody UmsAdminPermissionRelationExample example);
    @GetMapping("/deleteByExample")
    int deleteByExample(@RequestBody UmsAdminPermissionRelationExample example);
    @GetMapping("/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/insert")
    int insert(@RequestBody UmsAdminPermissionRelation record);
    @GetMapping("/insertSelective")
    int insertSelective(@RequestBody UmsAdminPermissionRelation record);
    @GetMapping("/selectByExample")
    List<UmsAdminPermissionRelation> selectByExample(@RequestBody UmsAdminPermissionRelationExample example);
    @GetMapping("/selectByPrimaryKey")
    UmsAdminPermissionRelation selectByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("record") UmsAdminPermissionRelation record, @RequestParam("example") UmsAdminPermissionRelationExample example);
    @GetMapping("/updateByExample")
    int updateByExample(@RequestParam("record") UmsAdminPermissionRelation record, @RequestParam("example") UmsAdminPermissionRelationExample example);
    @GetMapping("/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UmsAdminPermissionRelation record);
    @GetMapping("/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UmsAdminPermissionRelation record);
}