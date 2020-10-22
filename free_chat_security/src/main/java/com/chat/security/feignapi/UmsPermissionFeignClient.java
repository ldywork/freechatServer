package com.chat.security.feignapi;

import com.chat.backcontroll.api.UmsPermissionApi;
import org.springframework.cloud.openfeign.FeignClient;
@FeignClient("back-service")
public interface UmsPermissionFeignClient extends UmsPermissionApi {

}