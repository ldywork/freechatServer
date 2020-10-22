package com.chat.backcontroll.api;

import com.chat.backcontroll.model.UmsRole;
import com.chat.backcontroll.model.UmsRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UmsRoleApi {
    @GetMapping("/countByExample")
    int countByExample(@RequestBody UmsRoleExample example);
    @GetMapping("/deleteByExample")
    int deleteByExample(@RequestBody UmsRoleExample example);
    @GetMapping("/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/insert")
    int insert(@RequestBody UmsRole record);
    @GetMapping("/insertSelective")
    int insertSelective(@RequestBody UmsRole record);
    @GetMapping("/selectByExample")
    List<UmsRole> selectByExample(@RequestBody UmsRoleExample example);
    @GetMapping("/selectByPrimaryKey")
    UmsRole selectByPrimaryKey(@RequestParam("id") Long id);
    @GetMapping("/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("record") UmsRole record, @RequestParam("example") UmsRoleExample example);
    @GetMapping("/updateByExample")
    int updateByExample(@RequestParam("record") UmsRole record, @RequestParam("example") UmsRoleExample example);
    @GetMapping("/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UmsRole record);
    @GetMapping("/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UmsRole record);
}