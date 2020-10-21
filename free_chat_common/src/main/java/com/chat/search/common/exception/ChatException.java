package com.chat.search.common.exception;

import com.chat.search.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * 描述:异常处理类
 *
 * @Author: Ldy
 * @Date 2019/11/11 10:44
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
}
