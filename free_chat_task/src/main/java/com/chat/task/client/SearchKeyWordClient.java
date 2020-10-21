package com.chat.task.client;

import com.chat.search.pojo.IntoMessage;
import com.chat.search.pojo.IntoMessageReqDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("search-service")
public interface SearchKeyWordClient{
    @PostMapping("where")
    public ResponseEntity<List<IntoMessage>> searchWhere(@RequestBody IntoMessageReqDTO intoMessageReqDTO);

}

