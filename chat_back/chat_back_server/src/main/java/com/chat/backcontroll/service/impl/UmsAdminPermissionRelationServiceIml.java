package com.chat.backcontroll.service.impl;

import com.chat.backcontroll.mapper.UmsAdminPermissionRelationMapper;
import com.chat.backcontroll.model.UmsAdminPermissionRelation;
import com.chat.backcontroll.model.UmsAdminPermissionRelationExample;
import com.chat.backcontroll.service.UmsAdminPermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:35
 * @description：实现类
 * @modified By：
 * @version: $
 */
@Service
public class UmsAdminPermissionRelationServiceIml implements UmsAdminPermissionRelationService {
    @Autowired
    private UmsAdminPermissionRelationMapper umsAdminPermissionRelationMapper;
    @Override
    public int countByExample(UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsAdminPermissionRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsAdminPermissionRelation record) {
        return umsAdminPermissionRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsAdminPermissionRelation record) {
        return umsAdminPermissionRelationMapper.insertSelective(record);
    }

    @Override
    public List<UmsAdminPermissionRelation> selectByExample(UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationMapper.selectByExample(example);
    }

    @Override
    public UmsAdminPermissionRelation selectByPrimaryKey(Long id) {
        return umsAdminPermissionRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsAdminPermissionRelation record, UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UmsAdminPermissionRelation record, UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsAdminPermissionRelation record) {
        return umsAdminPermissionRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsAdminPermissionRelation record) {
        return umsAdminPermissionRelationMapper.updateByPrimaryKey(record);
    }
}
