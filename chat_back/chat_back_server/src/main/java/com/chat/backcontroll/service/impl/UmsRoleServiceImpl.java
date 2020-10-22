package com.chat.backcontroll.service.impl;

import com.chat.backcontroll.mapper.UmsRoleMapper;
import com.chat.backcontroll.model.UmsRole;
import com.chat.backcontroll.model.UmsRoleExample;
import com.chat.backcontroll.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:47
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleMapper umsRoleMapper;
    @Override
    public int countByExample(UmsRoleExample example) {
        return umsRoleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsRoleExample example) {
        return umsRoleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsRole record) {
        return umsRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsRole record) {
        return umsRoleMapper.insertSelective(record);
    }

    @Override
    public List<UmsRole> selectByExample(UmsRoleExample example) {
        return umsRoleMapper.selectByExample(example);
    }

    @Override
    public UmsRole selectByPrimaryKey(Long id) {
        return umsRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsRole record, UmsRoleExample example) {
        return umsRoleMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UmsRole record, UmsRoleExample example) {
        return umsRoleMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsRole record) {
        return umsRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsRole record) {
        return umsRoleMapper.updateByPrimaryKey(record);
    }
}
