package com.chat.search.repository;


import com.chat.search.pojo.IntoMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IntoMessageRepository extends ElasticsearchRepository<IntoMessage,Long> {

}
