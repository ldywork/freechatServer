package com.chat.backcontroll.web;


import com.chat.backcontroll.api.SearchAnalyzeApi;
import com.chat.backcontroll.keywordimpl.KeyWordAnalyzeService;
import com.chat.backcontroll.entity.SearchAnalyze;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述:关键字
 *
 * @Author: Ldy
 * @Date 2019/11/14 11:40
 **/
@RestController
@RequestMapping("keyWord")
public class KeyWordAnalyzeController implements SearchAnalyzeApi {

    @Autowired
    private KeyWordAnalyzeService keyWordAnalyzeService;

    @Override
    public ResponseEntity<Integer> addSearchAnalyzeKeyWord(@RequestBody List<SearchAnalyze> searchAnalyze) {
        return ResponseEntity.ok(keyWordAnalyzeService.batchInsertMessage(searchAnalyze));
    }

    @Override
    public ResponseEntity<String> getOneKeyWord( String flagWords) {
        return ResponseEntity.ok(keyWordAnalyzeService.getOneKeyWord(flagWords));
    }

    @GetMapping("localCheck")
    public ResponseEntity<SearchAnalyze> localCheck( String flagWords) {
        return ResponseEntity.ok(keyWordAnalyzeService.localCheck(flagWords));
    }
    @Override
    public Integer updateKeyWordMeans(@RequestBody SearchAnalyze searchAnalyze) {
        return keyWordAnalyzeService.updateKeyWordMeans(searchAnalyze);
    }
    @Override
    public Integer updateFlag() {
        return keyWordAnalyzeService.updateFlag();
    }

}
