package com.chat.search.pojo;

import lombok.Data;

import java.util.Date;


@Data
/**
 * 描述:es信息返回
 *
 * @Author: Ldy
 * @Date 2019/11/1 17:45
 **/
public class IntoMessageResVo {
    private Long id;
    /**
     * 关键字
     */
    private String keyWord;
    /**
     * 详细信息
     */
    private String all;
    /**
     * 创建时间
     */
    private String createDateMessage;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private String updateDateMessage;
    /**
     * 修改时间
     */
    private Date updateDate;

}