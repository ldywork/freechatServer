package com.chat.backcontroll.web;

import com.chat.backcontroll.api.UmsAdminPermissionRelationApi;
import com.chat.backcontroll.model.UmsAdminPermissionRelation;
import com.chat.backcontroll.model.UmsAdminPermissionRelationExample;
import com.chat.backcontroll.service.UmsAdminPermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ldy
 * @date ：Created in 2020/10/23 13:56
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("umsAdminPermissionRelation")
public class UmsAdminPermissionRelationController implements UmsAdminPermissionRelationApi {
    @Autowired
    private UmsAdminPermissionRelationService umsAdminPermissionRelationService;
    @Override
    public int countByExample(UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationService.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsAdminPermissionRelationService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsAdminPermissionRelation record) {
        return umsAdminPermissionRelationService.insert(record);
    }

    @Override
    public int insertSelective(UmsAdminPermissionRelation record) {
        return umsAdminPermissionRelationService.insertSelective(record);
    }

    @Override
    public List<UmsAdminPermissionRelation> selectByExample(UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationService.selectByExample(example);
    }

    @Override
    public UmsAdminPermissionRelation selectByPrimaryKey(Long id) {
        return umsAdminPermissionRelationService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsAdminPermissionRelation record, UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationService.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UmsAdminPermissionRelation record, UmsAdminPermissionRelationExample example) {
        return umsAdminPermissionRelationService.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsAdminPermissionRelation record) {
        return umsAdminPermissionRelationService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsAdminPermissionRelation record) {
        return umsAdminPermissionRelationService.updateByPrimaryKey(record);
    }

}
