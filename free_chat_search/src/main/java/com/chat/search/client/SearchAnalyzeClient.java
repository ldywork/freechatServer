package com.chat.search.client;

import com.chat.backcontroll.api.SearchAnalyzeApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("back-service")
public interface SearchAnalyzeClient extends SearchAnalyzeApi {

}
