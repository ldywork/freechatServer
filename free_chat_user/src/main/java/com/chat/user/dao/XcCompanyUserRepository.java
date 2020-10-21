package com.chat.user.dao;


import com.chat.model.entity.XcCompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator.
 */
public interface XcCompanyUserRepository extends JpaRepository<XcCompanyUser,String> {
    //根据用户id查询该用户所属的公司id
    XcCompanyUser findByUserId(String userId);
}
