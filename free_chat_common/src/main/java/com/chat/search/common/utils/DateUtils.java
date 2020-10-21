package com.chat.search.common.utils;


import com.chat.search.common.enums.ExceptionEnum;
import com.chat.search.common.exception.ChatException;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 描述:时间工具类
 *
 * @Author: Ldy
 * @Date 2019/11/6 14:55
 **/
public class DateUtils {
    /**
      * 描述: 获取字符串类型时间
        * @param date :
      * @return java.lang.String
     **/
    private static String  DATE_TO_STRING_WITH_SECOND = "yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒";
    public static String getTimeString(Date date){
        SimpleDateFormat f=new SimpleDateFormat(DATE_TO_STRING_WITH_SECOND);
        if (null == date ){
            throw new ChatException(ExceptionEnum.DATE_FORMAT_ERROR);
        }
        return f.format(date);
    }
    public static Long getCurrentMillis(){
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        String timeString = getTimeString(new Date());
        System.out.println(timeString);
    }
}
