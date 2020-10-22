package com.chat.backcontroll.service.impl;

import com.chat.backcontroll.mapper.UmsPermissionMapper;
import com.chat.backcontroll.model.UmsPermission;
import com.chat.backcontroll.model.UmsPermissionExample;
import com.chat.backcontroll.service.UmsPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:44
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class UmsPermissionServiceImpl implements UmsPermissionService {
    @Autowired
    private UmsPermissionMapper umsPermissionMapper;
    @Override
    public int countByExample(UmsPermissionExample example) {
        return umsPermissionMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsPermissionExample example) {
        return umsPermissionMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsPermission record) {
        return umsPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsPermission record) {
        return umsPermissionMapper.insertSelective(record);
    }

    @Override
    public List<UmsPermission> selectByExample(UmsPermissionExample example) {
        return umsPermissionMapper.selectByExample(example);
    }

    @Override
    public UmsPermission selectByPrimaryKey(Long id) {
        return umsPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsPermission record, UmsPermissionExample example) {
        return umsPermissionMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UmsPermission record, UmsPermissionExample example) {
        return umsPermissionMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsPermission record) {
        return umsPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsPermission record) {
        return 0;
    }
}
