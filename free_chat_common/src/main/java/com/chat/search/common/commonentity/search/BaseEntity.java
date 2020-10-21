package com.chat.search.common.commonentity.search;

import com.chat.search.common.utils.DateUtils;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

public class BaseEntity {
    /**
     * 创建时间
     */
    @Field(type = FieldType.Text,store = true)
    private String createDate = DateUtils.getTimeString(new Date());
    /**
     * 修改时间
     */
    @Field(type = FieldType.Text,store = true)
    private String updateDate = DateUtils.getTimeString(new Date());

}
