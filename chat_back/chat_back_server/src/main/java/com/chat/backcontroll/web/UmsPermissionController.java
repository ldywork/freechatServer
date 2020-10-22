package com.chat.backcontroll.web;

import com.chat.backcontroll.api.UmsPermissionApi;
import com.chat.backcontroll.model.UmsPermission;
import com.chat.backcontroll.model.UmsPermissionExample;
import com.chat.backcontroll.service.UmsPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:44
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("umsPermission")
public class UmsPermissionController implements UmsPermissionApi {
    @Autowired
    private UmsPermissionService umsPermissionService;
    @Override
    public int countByExample(UmsPermissionExample example) {
        return umsPermissionService.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsPermissionExample example) {
        return umsPermissionService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsPermissionService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsPermission record) {
        return umsPermissionService.insert(record);
    }

    @Override
    public int insertSelective(UmsPermission record) {
        return umsPermissionService.insertSelective(record);
    }

    @Override
    public List<UmsPermission> selectByExample(UmsPermissionExample example) {
        return umsPermissionService.selectByExample(example);
    }

    @Override
    public UmsPermission selectByPrimaryKey(Long id) {
        return umsPermissionService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsPermission record, UmsPermissionExample example) {
        return umsPermissionService.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UmsPermission record, UmsPermissionExample example) {
        return umsPermissionService.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsPermission record) {
        return umsPermissionService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsPermission record) {
        return 0;
    }
}
