package com.chat.backcontroll.web;

import com.chat.backcontroll.api.UmsAdminRoleRelationApi;
import com.chat.backcontroll.model.UmsAdminRoleRelation;
import com.chat.backcontroll.model.UmsAdminRoleRelationExample;
import com.chat.backcontroll.model.UmsPermission;
import com.chat.backcontroll.service.UmsAdminRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:40
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("umsAdminRoleRelation")
public class UmsAdminRoleRelationController implements UmsAdminRoleRelationApi {
    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;
    @Override
    public int countByExample(UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationService.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsAdminRoleRelationService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsAdminRoleRelation record) {
        return umsAdminRoleRelationService.insert(record);
    }

    @Override
    public int insertSelective(UmsAdminRoleRelation record) {
        return umsAdminRoleRelationService.insertSelective(record);
    }

    @Override
    public List<UmsAdminRoleRelation> selectByExample(UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationService.selectByExample(example);
    }

    @Override
    public UmsAdminRoleRelation selectByPrimaryKey(Long id) {
        return umsAdminRoleRelationService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsAdminRoleRelation record, UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationService.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UmsAdminRoleRelation record, UmsAdminRoleRelationExample example) {
        return umsAdminRoleRelationService.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsAdminRoleRelation record) {
        return umsAdminRoleRelationService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsAdminRoleRelation record) {
        return umsAdminRoleRelationService.updateByPrimaryKey(record);
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsAdminRoleRelationService.getPermissionList(adminId);
    }
}
