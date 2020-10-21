package com.chat.search.api;

import com.chat.search.pojo.IntoMessage;
import com.chat.search.pojo.IntoMessageReqDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 描述:搜索服务接口
 *
 * @Author: Ldy
 * @Date 2019/11/15 9:36
 **/
public interface SearchKeyWordApi {
    @PostMapping ("where")
    public ResponseEntity<List<IntoMessage>> searchWhere(@RequestBody IntoMessageReqDTO intoMessageReqDTO);
}
