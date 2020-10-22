package com.chat.backcontroll.service.impl;

import com.chat.backcontroll.mapper.UmsAdminMapper;
import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.model.UmsAdminExample;
import com.chat.backcontroll.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: Parent
 * @Package: com.chat.backcontroll.service.impl
 * @ClassName: UmsAdminServiceImpl
 * @Description: java类作用描述
 * @Author: ldy
 * @CreateDate: 2020/10/21 21:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/21 21:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Override
    public int countByExample(UmsAdminExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(UmsAdminExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(UmsAdmin record) {
        return 0;
    }

    @Override
    public int insertSelective(UmsAdmin record) {
        return 0;
    }

    @Override
    public List<UmsAdmin> selectByExample(UmsAdminExample example) {
        return null;
    }

    @Override
    public UmsAdmin selectByPrimaryKey(Long id) {
        return umsAdminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UmsAdmin record, UmsAdminExample example) {
        return 0;
    }

    @Override
    public int updateByExample(UmsAdmin record, UmsAdminExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(UmsAdmin record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UmsAdmin record) {
        return 0;
    }
}
