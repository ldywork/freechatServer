package com.chat.backcontroll.web;

import com.chat.backcontroll.api.SearchAnalyzeApi;
import com.chat.backcontroll.api.UmsAdminApi;
import com.chat.backcontroll.entity.SearchAnalyze;
import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: Parent
 * @Package: com.chat.backcontroll.web
 * @ClassName: UmsAdminController
 * @Description: java类作用描述
 * @Author: ldy
 * @CreateDate: 2020/10/21 21:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/21 21:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
public class UmsAdminController implements UmsAdminApi {
    @Autowired
    private UmsAdminService umsAdminService;
    @Override
    public UmsAdmin selectByPrimaryKey(Long id) {
        return umsAdminService.selectByPrimaryKey(id);
    }
}
