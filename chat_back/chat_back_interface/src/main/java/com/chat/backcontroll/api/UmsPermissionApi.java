package com.chat.backcontroll.api;

import com.chat.backcontroll.model.UmsPermission;
import com.chat.backcontroll.model.UmsPermissionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UmsPermissionApi {
    @GetMapping("/countByExample")
    int countByExample(@RequestBody UmsPermissionExample example);
    @GetMapping("/deleteByExample")
    int deleteByExample(@RequestBody UmsPermissionExample example);
    @GetMapping("/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/insert")
    int insert(@RequestBody UmsPermission record);
    @GetMapping("/insertSelective")
    int insertSelective(@RequestBody UmsPermission record);
    @GetMapping("/selectByExample")
    List<UmsPermission> selectByExample(@RequestBody UmsPermissionExample example);
    @GetMapping("/selectByPrimaryKey")
    UmsPermission selectByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("record") UmsPermission record, @RequestParam("example") UmsPermissionExample example);
    @GetMapping("/updateByExample")
    int updateByExample(@RequestParam("record") UmsPermission record, @RequestParam("example") UmsPermissionExample example);
    @GetMapping("/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UmsPermission record);
    @GetMapping("/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UmsPermission record);
}