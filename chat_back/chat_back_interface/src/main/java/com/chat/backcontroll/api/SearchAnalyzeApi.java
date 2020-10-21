package com.chat.backcontroll.api;

import com.chat.backcontroll.entity.SearchAnalyze;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 描述:后台feign调用接口
 *
 * @Author: Ldy
 * @Date 2019/11/14 11:42
 **/
@RequestMapping("keyWord")
public interface SearchAnalyzeApi {
    /**
     * 描述: 批量添加关键字
     *
     * @param searchAnalyze :
     * @return java.lang.Integer
     **/
    @PostMapping("add")
    public ResponseEntity<Integer> addSearchAnalyzeKeyWord(@RequestBody List<SearchAnalyze> searchAnalyze);

    /**
     * 描述: 查询一个关键字,参数可以为空,这样随意返回一个关键字,否则按照参数模糊搜索并返回一个
     *
     * @param flagWords :
     * @return org.springframework.http.ResponseEntity<java.lang.Integer>
     **/
    @PostMapping("getOne")
    public ResponseEntity<String> getOneKeyWord( String flagWords);
    /**
     * 描述: 修改信息
     * @param searchAnalyze :
     * @return java.lang.Integer
     **/
    @PostMapping("update")
    public Integer updateKeyWordMeans(@RequestBody SearchAnalyze searchAnalyze);

    /**
     * 描述: 修改因为系统问题修改出现flag为1但是means为空的数据,将flag改为0
     * @return java.lang.Integer
     **/
    @PostMapping("updateFlag/whereMessageIsNull")
    public Integer updateFlag();
}
