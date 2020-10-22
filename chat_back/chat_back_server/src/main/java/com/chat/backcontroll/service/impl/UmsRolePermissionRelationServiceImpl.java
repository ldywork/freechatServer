package com.chat.backcontroll.service.impl;

import com.chat.backcontroll.mapper.UmsRolePermissionRelationMapper;
import com.chat.backcontroll.model.UmsRolePermissionRelation;
import com.chat.backcontroll.model.UmsRolePermissionRelationExample;
import com.chat.backcontroll.service.UmsRolePermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:50
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class UmsRolePermissionRelationServiceImpl implements UmsRolePermissionRelationService {
    @Autowired
    private UmsRolePermissionRelationMapper umsRolePermissionRelationMapper;
    @Override
    public int countByExample(UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationMapper.countByExample( example);
    }

    @Override
    public int deleteByExample(UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationMapper.deleteByExample( example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsRolePermissionRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsRolePermissionRelation record) {
        return umsRolePermissionRelationMapper.insert( record);
    }

    @Override
    public int insertSelective(UmsRolePermissionRelation record) {
        return umsRolePermissionRelationMapper.insertSelective(record);
    }

    @Override
    public List<UmsRolePermissionRelation> selectByExample(UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationMapper.selectByExample(example);
    }

    @Override
    public UmsRolePermissionRelation selectByPrimaryKey(Long id) {
        return umsRolePermissionRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsRolePermissionRelation record, UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationMapper.updateByExampleSelective( record,  example);
    }

    @Override
    public int updateByExample(UmsRolePermissionRelation record, UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationMapper.updateByExample( record,  example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsRolePermissionRelation record) {
        return umsRolePermissionRelationMapper.updateByPrimaryKeySelective( record);
    }

    @Override
    public int updateByPrimaryKey(UmsRolePermissionRelation record) {
        return umsRolePermissionRelationMapper.updateByPrimaryKey( record);
    }
}
