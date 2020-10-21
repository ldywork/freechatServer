package com.chat.search.pojo;

import com.chat.search.common.utils.DateUtils;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;


@Data
@Document(indexName = "chat", type = "start", shards = 1, replicas = 0)
/**
 * 描述:信息引入
 *
 * @Author: Ldy
 * @Date 2019/11/1 17:45
 **/
public class IntoMessage {
    @Id
    private Long id;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String keyWord;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String all;
    /**
     * 创建时间
     */
    @Field(type = FieldType.Text,index = false)
    private String createDateMessage = DateUtils.getTimeString(new Date());
    /**
     * 创建时间
     */
    @Field(type = FieldType.Date)
    private Date createDate = new Date();
    /**
     * 修改时间
     */
    @Field(type = FieldType.Text,index = false)
    private String updateDateMessage = DateUtils.getTimeString(new Date());
    /**
     * 修改时间
     */
    @Field(type = FieldType.Date)
    private Date updateDate = new Date();

}