package com.chat.security.feignapi;

import com.chat.backcontroll.api.UmsAdminPermissionRelationApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("back-service")
public interface UmsAdminPermissionRelationFeignClient extends UmsAdminPermissionRelationApi {

}