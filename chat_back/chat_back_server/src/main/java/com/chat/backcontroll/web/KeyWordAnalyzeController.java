package com.chat.backcontroll.web;


import com.chat.backcontroll.keywordimpl.KeyWordAnalyzeService;
import com.chat.backcontroll.entity.SearchAnalyze;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class KeyWordAnalyzeController {

    @Autowired
    private KeyWordAnalyzeService keyWordAnalyzeService;

    /**
     * 描述: 批量添加关键字
     *
     * @param searchAnalyze :
     * @return ResponseEntity<java.lang.Integer>
     **/
    @PreAuthorize("hasAuthority('course_teachplan_list')")
    @PostMapping("add")
    public ResponseEntity<Integer> addSearchAnalyzeKeyWord(@RequestBody List<SearchAnalyze> searchAnalyze) {
        return ResponseEntity.ok(keyWordAnalyzeService.batchInsertMessage(searchAnalyze));
    }

    /**
     * 描述: 查询一个关键字,参数可以为空,这样随意返回一个关键字,否则按照参数模糊搜索并返回一个
     *
     * @param flagWords :
     * @return org.springframework.http.ResponseEntity<java.lang.Integer>
     **/
    @PreAuthorize("hasAuthority('course_find_list')")
    @RequestMapping("getOne")
    public ResponseEntity<String> getOneKeyWord( String flagWords) {
        return ResponseEntity.ok(keyWordAnalyzeService.getOneKeyWord(flagWords));
    }
/**
 * @Description:本地查询
 * @Author: ldy
 * @Date: 2020/4/20 11:09
  * @param null
 * @return: null
 **/
    @PreAuthorize("hasAuthority('course_find_list')")
    @GetMapping("localCheck")
    public ResponseEntity<SearchAnalyze> localCheck( String flagWords) {
        return ResponseEntity.ok(keyWordAnalyzeService.localCheck(flagWords));
    }
    /**
     * 描述: 根据关键字修改信息修改信息
     *
     * @param searchAnalyze :
     * @return java.lang.Integer
     **/
    @PostMapping("update")
    public Integer updateKeyWordMeans(@RequestBody SearchAnalyze searchAnalyze) {
        return keyWordAnalyzeService.updateKeyWordMeans(searchAnalyze);
    }

    /**
     * 描述: 修改因为系统问题修改出现flag为1但是means为空的数据,将flag改为0
     * @return java.lang.Integer
     **/
    @PostMapping("updateFlag/whereMessageIsNull")
    public Integer updateFlag() {
        return keyWordAnalyzeService.updateFlag();
    }

}
