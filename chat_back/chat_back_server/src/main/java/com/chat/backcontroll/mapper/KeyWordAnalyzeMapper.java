package com.chat.backcontroll.mapper;


import com.chat.backcontroll.entity.SearchAnalyze;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
/**
 * 描述:关键字mapper
 *
 * @Author: Ldy
 * @Date 2019/11/14 14:04
 **/
public interface KeyWordAnalyzeMapper extends BaseMapper<SearchAnalyze> {
    /**
      * 描述: 批量插入数据
        * @param searchAnalyzeList :
      * @return java.lang.Integer
     **/
    @Insert({"<script>"+
            "insert ignore into chat_search_analyze(key_word,means,priority_level,create_time,create_name," +
                    "update_time,update_name) values " +
                    "<foreach item='value' index='key' collection='searchAnalyzeList' separator=','>" +
                    "(#{value.keyWord},#{value.means},#{value.priorityLevel},#{value.createTime},#{value.createName},#{value.updateTime},#{value.updateName})" +
                    "</foreach></script>"

    })
    Integer batchInsertMessage(@Param("searchAnalyzeList") List<SearchAnalyze> searchAnalyzeList);

    /**
      * 描述: 获取一个关键字
        * @param flagWords :
      * @return java.lang.String
     **/
    @Select({
            "<script> select id, key_word as keyWord, get_netsource as getNetsource ,means as means, priority_level as priorityLevel," +
                    " create_time as createTime , create_name as createName,update_time as updateTime ,update_name as updateName " +
                    "from chat_search_analyze where get_netsource = 0 " +
                    "<if test='flagWords != null'>" +
                        "and key_word like  CONCAT('%',#{flagWords},'%') " +
                    "</if> limit 1 </script>"
    })
    SearchAnalyze getOneKeyWord(@Param("flagWords")String flagWords);

    /**
     * 描述: 获取一个关键字
     * @param flagWords :
     * @return java.lang.String
     **/
    @Select({
            "<script> select id, key_word as keyWord, get_netsource as getNetsource ,means as means, priority_level as priorityLevel," +
                    " create_time as createTime , create_name as createName,update_time as updateTime ,update_name as updateName " +
                    "from chat_search_analyze where get_netsource = 1 " +
                    "<if test='flagWords != null'>" +
                    "and key_word like  CONCAT('%',#{flagWords},'%') " +
                    "</if> limit 1 </script>"
    })
    SearchAnalyze localCheck(@Param("flagWords")String flagWords);
    /**
      * 描述: 修改关键字信息添加释义
        * @param searchAnalyze :
      * @return java.lang.Integer
     **/
    @Update({
            "<script> update  chat_search_analyze" +
                    " set get_netsource = 1" +
                    "<if test='searchAnalyze.means != null' >" +
                        " ,means = #{searchAnalyze.means} " +
                    "</if>" +
                    "<if test='searchAnalyze.createTime != null' >" +
                        ",create_time = #{searchAnalyze.createTime} " +
                    "</if>" +
                    "<if test='searchAnalyze.updateTime != null' >" +
                        ",update_time = #{searchAnalyze.updateTime} " +
                    "</if>" +
                    "<if test='searchAnalyze.createName != null' >" +
                        ",create_name = #{searchAnalyze.createName} " +
                    "</if>" +
                    "<if test='searchAnalyze.updateName != null' >" +
                        ",update_name = #{searchAnalyze.updateName} " +
                    "</if>" +
                    " where key_word = #{searchAnalyze.keyWord}" +
                    " </script>"
    })
    Integer updateKeyWordMeans(@Param("searchAnalyze")SearchAnalyze searchAnalyze);

    @Update(" UPDATE `chat_search_analyze` set get_netsource=0 where means is null ")
    Integer updateFlag();
}

