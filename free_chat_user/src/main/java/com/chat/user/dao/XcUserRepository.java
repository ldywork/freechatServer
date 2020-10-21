package com.chat.user.dao;


import com.chat.model.entity.XcUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator.
 */
public interface XcUserRepository extends JpaRepository<XcUser,String> {
    //根据账号查询用户信息
    XcUser findByUsername(String username);
}
