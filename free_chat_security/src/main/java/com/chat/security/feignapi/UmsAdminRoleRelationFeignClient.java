package com.chat.security.feignapi;

import com.chat.backcontroll.api.UmsAdminRoleRelationApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("back-service")
public interface UmsAdminRoleRelationFeignClient extends UmsAdminRoleRelationApi {

}