package com.chat.search.web;
import com.chat.search.pojo.IntoMessage;
import com.chat.search.pojo.IntoMessageReqDTO;
import com.chat.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:查询es
 *
 * @Author: Ldy
 * @Date 2019/11/1 15:54
 **/
@RestController
public class SearchController {
    @Autowired
    private SearchService searchService;
    @PostMapping("all")
    public ResponseEntity<List<IntoMessage>> searchAll(){
        return ResponseEntity.ok(searchService.searchAll());
    }
    @PostMapping ("where")
    public ResponseEntity<List<IntoMessage>> searchWhere(@RequestBody IntoMessageReqDTO intoMessageReqDTO){
        List<IntoMessage> intoMessageList = searchService.searchMessage(intoMessageReqDTO.getKeyWord());
        return ResponseEntity.ok(intoMessageList);
    }
    @PostMapping("test")
    public void test(){
        searchService.testFeign();
    }

}
