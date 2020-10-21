package com.chat.task.consumer;

import com.chat.backcontroll.entity.SearchAnalyze;
import com.chat.task.client.TaskAnalyzeClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
@RabbitListener(queues = "mq_message_task")
public class SerachConsumer {
    @Autowired
    private TaskAnalyzeClient taskAnalyzeClient;
    @RabbitHandler
    public void process(String searchMessage) {
        if (StringUtils.isEmpty(searchMessage)){
            log.error("需要分词的信息为空");
            return;
        }
        log.info("需要分词的信息:{}",searchMessage);
        StringReader messageReader = new StringReader(searchMessage);
        //这里的true是开启智能分词
        IKSegmenter ik= new IKSegmenter(messageReader,true);
        Set<String> analySet = new HashSet<>();
        Lexeme lex;
        try {
            while((lex = ik.next())!=null){
                analySet.add(lex.getLexemeText());
            }
        } catch (IOException e) {
            log.error("信息分词错误,信息:{}",searchMessage);
            e.printStackTrace();
        }
        //如果分词信息不为空,那么存储到数据库待后期查询
        if(!CollectionUtils.isEmpty(analySet)){
            List<SearchAnalyze> searchAnalyzeList = new ArrayList<>();
            for(String analy : analySet){
                SearchAnalyze searchAnalyze = new SearchAnalyze();
                searchAnalyze.setKeyWord(analy);
                searchAnalyzeList.add(searchAnalyze);
            }
            ResponseEntity<Integer> integerResponseEntity = taskAnalyzeClient.addSearchAnalyzeKeyWord(searchAnalyzeList);
            System.out.println(integerResponseEntity);
        }

    }


}
