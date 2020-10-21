package com.chat.backcontroll.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:映射类
 *
 * @Author: Ldy
 * @Date 2019/11/14 9:44
 **/
@Data
@Table(name = "chat_search_analyze")
public class SearchAnalyze extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -276346092203437735L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /*
    * 关键字
    */
    private String keyWord;
     /*
    * 查询标识
    */
    private Integer getNetsource;

    /*
    关键字释义
    */

    private String means;

    /*
    优先级,越大越高
    */
    private Integer priorityLevel;

    protected Date createTime = new Date();
    protected String createName;
    protected Date updateTime = new Date();
    protected String updateName;

}
