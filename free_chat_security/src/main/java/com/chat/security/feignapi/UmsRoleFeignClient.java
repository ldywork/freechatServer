package com.chat.security.feignapi;

import com.chat.backcontroll.api.UmsRoleApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("back-service")
public interface UmsRoleFeignClient extends UmsRoleApi {

}