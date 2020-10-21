package com.chat.backcontroll.keywordimpl;


import com.chat.backcontroll.entity.SearchAnalyze;
import com.chat.backcontroll.mapper.KeyWordAnalyzeMapper;
import com.chat.search.common.constants.NumConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:关键字service
 *
 * @Author: Ldy
 * @Date 2019/11/14 11:36
 **/
@Service
public class KeyWordAnalyzeService {
    @Autowired
    private KeyWordAnalyzeMapper keyWordAnalyzeMapper;

    /**
     * 描述: 批量插入关键字数据
     *
     * @param searchAnalyzeList :
     * @return java.lang.Integer
     **/
    public Integer batchInsertMessage(List<SearchAnalyze> searchAnalyzeList) {
        return keyWordAnalyzeMapper.batchInsertMessage(searchAnalyzeList);
    }

    /**
     * 描述: 获取一个关键字
     *
     * @param flagWords :
     * @return java.lang.String
     **/
    public String getOneKeyWord(String flagWords) {
        //feign的post不允许传递null所以传递空字符,然后在这里做处理
        if (null != flagWords && StringUtils.isEmpty(flagWords.trim())) {
            flagWords = null;
        }
        SearchAnalyze oneKeyWord = keyWordAnalyzeMapper.getOneKeyWord(flagWords);
        //修改getNetSource为1
        if (null == oneKeyWord){
            return null;
        }
        oneKeyWord.setGetNetsource(NumConstant.NUM_1);
        keyWordAnalyzeMapper.updateByPrimaryKey(oneKeyWord);
        return oneKeyWord.getKeyWord();
    }
    /**
     * @Description: 本地查询
     * @Author: ldy
     * @Date: 2020/4/20 11:07
      * @param
     * @return: null
     **/
    public SearchAnalyze localCheck(String flagWords) {
        //feign的post不允许传递null所以传递空字符,然后在这里做处理
        if (null != flagWords && StringUtils.isEmpty(flagWords.trim())) {
            flagWords = null;
        }
        return keyWordAnalyzeMapper.localCheck(flagWords);
    }
    /**
     * 描述: 修改信息
     *
     * @param searchAnalyze :
     * @return java.lang.Integer
     **/
    public Integer updateKeyWordMeans(SearchAnalyze searchAnalyze) {
        return keyWordAnalyzeMapper.updateKeyWordMeans(searchAnalyze);
    }

    public Integer updateFlag() {
        return keyWordAnalyzeMapper.updateFlag();
    }
}
