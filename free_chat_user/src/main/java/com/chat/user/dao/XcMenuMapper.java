package com.chat.user.dao;

import com.chat.model.entity.XcMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator.
 */
@Mapper
public interface XcMenuMapper {
    //根据用户id查询用户的权限
    @Select({
            "<script> SELECT id, CODE, p_id pId,  menu_name menuName, url, is_menu isMenu, LEVEL, sort, STATUS, icon,  create_time createTime,\n" +
                    " update_time updateTiem FROM xc_menu WHERE id IN (SELECT  menu_id  FROM xc_permission WHERE role_id IN  (SELECT\n" +
                    " role_id FROM xc_user_role WHERE user_id = #{userid})) </script>"
    })
    public List<XcMenu> selectPermissionByUserId(@Param("userid")String userid);
}
