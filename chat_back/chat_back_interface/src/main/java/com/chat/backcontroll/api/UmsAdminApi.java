package com.chat.backcontroll.api;

import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.model.UmsAdminExample;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
public interface UmsAdminApi {
    @GetMapping("/selectByPrimaryKey")
    public UmsAdmin selectByPrimaryKey( @RequestParam("id") Long id);
    @GetMapping("/countByExample")
    int countByExample(@RequestBody UmsAdminExample example);
    @GetMapping("/deleteByExample")
    int deleteByExample(@RequestBody UmsAdminExample example);
    @GetMapping("/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id")Long id);
    @GetMapping("/insert")
    int insert(@RequestBody UmsAdmin record);
    @GetMapping("/insertSelective")
    int insertSelective(@RequestBody UmsAdmin record);
    @GetMapping("/selectByExample")
    List<UmsAdmin> selectByExample(@RequestBody UmsAdminExample example);
    @GetMapping("/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("record") UmsAdmin record,@RequestParam("example") UmsAdminExample example);
    @GetMapping("/updateByExample")
    int updateByExample(@RequestParam("record") UmsAdmin record,@RequestParam("example") UmsAdminExample example);
    @GetMapping("/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UmsAdmin record);
    @GetMapping("/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UmsAdmin record);
}
