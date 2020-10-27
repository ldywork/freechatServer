package com.chat.backcontroll.api;

import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.model.UmsAdminExample;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: Parent
 * @Package: com.chat.backcontroll.api
 * @ClassName: UmsAdminApi
 * @Description: java类作用描述
 * @Author: ldy
 * @CreateDate: 2020/10/21 22:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/21 22:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RequestMapping("/umsAdmin")
public interface UmsAdminApi {
    @RequestMapping("/selectByPrimaryKey")
    public UmsAdmin selectByPrimaryKey( @RequestParam("id") Long id);
    @RequestMapping("/countByExample")
    int countByExample(@RequestBody UmsAdminExample example);
    @RequestMapping("/deleteByExample")
    int deleteByExample(@RequestBody UmsAdminExample example);
    @RequestMapping("/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id")Long id);
    @PostMapping("/insert")
    int insert(@RequestBody UmsAdmin record);
    @RequestMapping("/insertSelective")
    int insertSelective(@RequestBody UmsAdmin record);
    @PostMapping("/selectByExample")
    List<UmsAdmin> selectByExample(@RequestParam String userName);
    @RequestMapping("/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("record") UmsAdmin record,@RequestParam("example") UmsAdminExample example);
    @RequestMapping("/updateByExample")
    int updateByExample(@RequestParam("record") UmsAdmin record,@RequestParam("example") UmsAdminExample example);
    @RequestMapping("/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UmsAdmin record);
    @RequestMapping("/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UmsAdmin record);
}
