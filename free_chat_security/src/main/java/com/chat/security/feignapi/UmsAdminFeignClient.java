package com.chat.security.feignapi;

import com.chat.backcontroll.api.UmsAdminApi;
import com.chat.backcontroll.model.UmsAdmin;
import com.chat.backcontroll.model.UmsAdminExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
@FeignClient("back-service")
public interface UmsAdminFeignClient extends UmsAdminApi {

}
