package com.chat.security.feignapi;

import com.chat.backcontroll.api.UmsRolePermissionRelationApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("back-service")
public interface UmsRolePermissionRelationFeignClient extends UmsRolePermissionRelationApi {

}