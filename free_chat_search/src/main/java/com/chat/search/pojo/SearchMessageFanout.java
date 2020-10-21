package com.chat.search.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

import java.util.Collection;
import java.util.Iterator;

/**
 * 描述:消息服务发布订阅模式
 *
 * @Author: Ldy
 * @Date 2019/11/12 17:53
 **/
@Configuration
public class SearchMessageFanout {
    /**
     *任务服务来消费的队列
     */
    @Bean
    public Queue taskQueue(){
        return new Queue("mq_message_task");
    }
    /**
     *创建交换机
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("searchFanoutExchange");
    }
    /**
     *绑定队列到交换机
     */
    @Bean
    Binding bindingExchangeA(Queue taskQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(taskQueue).to(fanoutExchange);
    }

}
