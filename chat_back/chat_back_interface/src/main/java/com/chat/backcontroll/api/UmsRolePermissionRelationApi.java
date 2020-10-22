package com.chat.backcontroll.api;

import com.chat.backcontroll.model.UmsRolePermissionRelation;
import com.chat.backcontroll.model.UmsRolePermissionRelationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UmsRolePermissionRelationApi {
    @GetMapping("/countByExample")
    int countByExample(@RequestBody UmsRolePermissionRelationExample example);
    @GetMapping("/deleteByExample")
    int deleteByExample(@RequestBody UmsRolePermissionRelationExample example);
    @GetMapping("/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/insert")
    int insert(@RequestBody UmsRolePermissionRelation record);
    @GetMapping("/insertSelective")
    int insertSelective(@RequestBody UmsRolePermissionRelation record);
    @GetMapping("/selectByExample")
    List<UmsRolePermissionRelation> selectByExample(@RequestBody UmsRolePermissionRelationExample example);
    @GetMapping("/UmsRolePermissionRelation")
    UmsRolePermissionRelation selectByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("record") UmsRolePermissionRelation record, @RequestParam("example") UmsRolePermissionRelationExample example);
    @GetMapping("/updateByExample")
    int updateByExample(@RequestParam("record") UmsRolePermissionRelation record, @RequestParam("example") UmsRolePermissionRelationExample example);
    @GetMapping("/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UmsRolePermissionRelation record);
    @GetMapping("/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UmsRolePermissionRelation record);
}