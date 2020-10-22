package com.chat.backcontroll.web;

import com.chat.backcontroll.api.SearchAnalyzeApi;
import com.chat.backcontroll.api.UmsAdminApi;
import com.chat.backcontroll.entity.SearchAnalyze;
import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.model.UmsAdminExample;
import com.chat.backcontroll.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: Parent
 * @Package: com.chat.backcontroll.web
 * @ClassName: UmsAdminController
 * @Description: java类作用描述
 * @Author: ldy
 * @CreateDate: 2020/10/21 21:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/21 21:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
@RequestMapping("umsAdmin")
public class UmsAdminController implements UmsAdminApi {
    @Autowired
    private UmsAdminService umsAdminService;
    @Override
    public UmsAdmin selectByPrimaryKey(Long id) {
        return umsAdminService.selectByPrimaryKey(id);
    }
    @Override
    public int countByExample(UmsAdminExample example) {
        return umsAdminService.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsAdminExample example) {
        return umsAdminService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsAdminService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsAdmin record) {
        return umsAdminService.insert(record);
    }

    @Override
    public int insertSelective(UmsAdmin record) {
        return umsAdminService.insertSelective(record);
    }

    @Override
    public List<UmsAdmin> selectByExample(UmsAdminExample example) {
        return umsAdminService.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(UmsAdmin record, UmsAdminExample example) {
        return umsAdminService.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UmsAdmin record, UmsAdminExample example) {
        return umsAdminService.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsAdmin record) {
        return umsAdminService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsAdmin record) {
        return umsAdminService.updateByPrimaryKey(record);
    }

}
