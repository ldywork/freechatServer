package com.chat.search.common.advice;

import com.chat.search.common.exception.ChatException;
import com.chat.search.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(ChatException.class)
    public ResponseEntity<ExceptionResult> handlerException(ChatException e){
        return ResponseEntity.status(e.getExceptionEnum().getCode()).body(new ExceptionResult(e.getExceptionEnum()));
    }

}
