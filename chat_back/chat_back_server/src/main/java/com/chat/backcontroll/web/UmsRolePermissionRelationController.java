package com.chat.backcontroll.web;

import com.chat.backcontroll.api.UmsRolePermissionRelationApi;
import com.chat.backcontroll.model.UmsRolePermissionRelation;
import com.chat.backcontroll.model.UmsRolePermissionRelationExample;
import com.chat.backcontroll.service.UmsRolePermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:50
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("umsRolePermissionRelation")
public class UmsRolePermissionRelationController implements UmsRolePermissionRelationApi {
    @Autowired
    private UmsRolePermissionRelationService umsRolePermissionRelationService;
    @Override
    public int countByExample(UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationService.countByExample( example);
    }

    @Override
    public int deleteByExample(UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationService.deleteByExample( example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsRolePermissionRelationService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsRolePermissionRelation record) {
        return umsRolePermissionRelationService.insert( record);
    }

    @Override
    public int insertSelective(UmsRolePermissionRelation record) {
        return umsRolePermissionRelationService.insertSelective(record);
    }

    @Override
    public List<UmsRolePermissionRelation> selectByExample(UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationService.selectByExample(example);
    }

    @Override
    public UmsRolePermissionRelation selectByPrimaryKey(Long id) {
        return umsRolePermissionRelationService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsRolePermissionRelation record, UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationService.updateByExampleSelective( record,  example);
    }

    @Override
    public int updateByExample(UmsRolePermissionRelation record, UmsRolePermissionRelationExample example) {
        return umsRolePermissionRelationService.updateByExample( record,  example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsRolePermissionRelation record) {
        return umsRolePermissionRelationService.updateByPrimaryKeySelective( record);
    }

    @Override
    public int updateByPrimaryKey(UmsRolePermissionRelation record) {
        return umsRolePermissionRelationService.updateByPrimaryKey( record);
    }
}
