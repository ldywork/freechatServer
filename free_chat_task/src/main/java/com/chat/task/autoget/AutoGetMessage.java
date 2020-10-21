package com.chat.task.autoget;

import com.chat.search.common.thread.ThreadUtil;
import com.chat.search.pojo.IntoMessageReqDTO;
import com.chat.task.client.TaskAnalyzeClient;
import com.chat.task.client.SearchKeyWordClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 描述:获取信息的定时任务
 *
 * @Author: Ldy
 * @Date 2019/11/7 11:30
 **/
@Component
@Configuration
@EnableScheduling
@Slf4j
public class AutoGetMessage {
    @Autowired
    private TaskAnalyzeClient taskAnalyzeClient;
    @Autowired
    private SearchKeyWordClient searchKeyWordClient;
    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate=100000)
    private void configureTasks() {
        long start = System.currentTimeMillis();
        ResponseEntity<String> oneKeyWord = taskAnalyzeClient.getOneKeyWord("      ");
        String body = oneKeyWord.getBody();
        if (StringUtils.isEmpty(body)){
            log.info("获取关键字失败,关键字:"+body);
            return;
        }
        System.out.println("任务时间间隔为:"+(System.currentTimeMillis()-start));
        log.info("执行静态定时任务时间:自动获取关键字<<"+body+">>,调用搜索服务 " + LocalDateTime.now());
        //调用搜索服务
        IntoMessageReqDTO intoMessageReqDTO = new IntoMessageReqDTO();
        intoMessageReqDTO.setKeyWord(body);
        ThreadUtil.excute(()-> searchKeyWordClient.searchWhere(intoMessageReqDTO));
    }
}
