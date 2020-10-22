package com.chat.backcontroll.service.impl;

import com.chat.backcontroll.mapper.UmsAdminRoleRelationMapper;
import com.chat.backcontroll.model.UmsAdminRoleRelation;
import com.chat.backcontroll.model.UmsAdminRoleRelationExample;
import com.chat.backcontroll.model.UmsPermission;
import com.chat.backcontroll.service.UmsAdminRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:40
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class UmsAdminRoleRelationServiceImpl implements UmsAdminRoleRelationService {
    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;
    @Override
    public int countByExample(UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsAdminRoleRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsAdminRoleRelation record) {
        return umsAdminRoleRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsAdminRoleRelation record) {
        return umsAdminRoleRelationMapper.insertSelective(record);
    }

    @Override
    public List<UmsAdminRoleRelation> selectByExample(UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationMapper.selectByExample(example);
    }

    @Override
    public UmsAdminRoleRelation selectByPrimaryKey(Long id) {
        return umsAdminRoleRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsAdminRoleRelation record, UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UmsAdminRoleRelation record, UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsAdminRoleRelation record) {
        return umsAdminRoleRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsAdminRoleRelation record) {
        return umsAdminRoleRelationMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsAdminRoleRelationMapper.getPermissionList(adminId);
    }
}
