package com.chat.backcontroll.hiberentity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:映射类
 *
 * @Author: Ldy
 * @Date 2019/11/14 9:44
 **/
@Data
@Entity
@Table(name = "chat_search_analyze")
public class HiberSearchAnalyze implements Serializable{

    private static final long serialVersionUID = -276346092203437735L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    * 关键字
    */
    @Column(name = "key_word")
    private String keyWord;
    /*
    * 查询标识
    */
     @Column(name = "get_netsource")
    private Integer getNetsource;

    /*
    关键字释义
    */
    @Column(name = "means")
    private String means;

    /*
    优先级,越大越高
    */
    @Column(name = "priority_level")
    private Integer priorityLevel;
    @Column(name = "create_time")
    protected Date createTime = new Date();
    @Column(name = "create_name")
    protected String createName;
    @Column(name = "update_time")
    protected Date updateTime = new Date();
    @Column(name = "update_name")
    protected String updateName;

}
