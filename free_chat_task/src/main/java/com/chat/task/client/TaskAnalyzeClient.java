package com.chat.task.client;

import com.chat.backcontroll.api.SearchAnalyzeApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("back-service")
public interface TaskAnalyzeClient extends SearchAnalyzeApi {

}
