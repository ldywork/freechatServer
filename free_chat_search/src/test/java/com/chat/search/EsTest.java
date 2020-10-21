package com.chat.search;

import com.chat.search.pojo.IntoMessage;
import com.chat.search.repository.IntoMessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {
    @Autowired
    private IntoMessageRepository intoMessageRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Test
    public void init(){
        //创建索引库
        elasticsearchTemplate.createIndex(IntoMessage.class);
        //创建映射
        elasticsearchTemplate.putMapping(IntoMessage.class);
    }
    @Test
        public void addMessage(){
        IntoMessage intoMessage = new IntoMessage();
        intoMessage.setId(1L);
        intoMessage.setAll("HELLO WORD");
        intoMessageRepository.save(intoMessage);
//        Iterable<IntoMessage> all = intoMessageRepository.findAll();
    }
}
