package com.chat.backcontroll.web;

import com.chat.backcontroll.api.UmsRoleApi;
import com.chat.backcontroll.model.UmsRole;
import com.chat.backcontroll.model.UmsRoleExample;
import com.chat.backcontroll.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:47
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("umsRole")
public class UmsRoleController implements UmsRoleApi {
    @Autowired
    private UmsRoleService umsRoleService;
    @Override
    public int countByExample(UmsRoleExample example) {
        return umsRoleService.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsRoleExample example) {
        return umsRoleService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsRoleService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsRole record) {
        return umsRoleService.insert(record);
    }

    @Override
    public int insertSelective(UmsRole record) {
        return umsRoleService.insertSelective(record);
    }

    @Override
    public List<UmsRole> selectByExample(UmsRoleExample example) {
        return umsRoleService.selectByExample(example);
    }

    @Override
    public UmsRole selectByPrimaryKey(Long id) {
        return umsRoleService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsRole record, UmsRoleExample example) {
        return umsRoleService.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UmsRole record, UmsRoleExample example) {
        return umsRoleService.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsRole record) {
        return umsRoleService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsRole record) {
        return umsRoleService.updateByPrimaryKey(record);
    }
}
