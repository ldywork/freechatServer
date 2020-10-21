package com.chat.search.common.vo;

import com.chat.search.common.enums.ExceptionEnum;
import lombok.Data;

@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum e) {
        this.status = e.getCode();
        this.message = e.getMessage();
        this.timestamp = System.currentTimeMillis();
    }
}
