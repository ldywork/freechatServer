package com.chat.backcontroll.service;

import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.model.UmsAdminExample;

import java.util.List;

public interface UmsAdminService {
    int countByExample(UmsAdminExample example);

    int deleteByExample(UmsAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    List<UmsAdmin> selectByExample(UmsAdminExample example);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(UmsAdmin record,UmsAdminExample example);

    int updateByExample( UmsAdmin record, UmsAdminExample example);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);
}