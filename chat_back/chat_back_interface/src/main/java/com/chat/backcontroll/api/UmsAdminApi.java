package com.chat.backcontroll.api;

import com.chat.backcontroll.model.UmsAdmin;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ProjectName: Parent
 * @Package: com.chat.backcontroll.api
 * @ClassName: UmsAdminApi
 * @Description: java类作用描述
 * @Author: ldy
 * @CreateDate: 2020/10/21 22:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/21 22:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface UmsAdminApi {
    @GetMapping("/umsAdmin/selectByPrimaryKey")
    public UmsAdmin selectByPrimaryKey( Long id);
}
