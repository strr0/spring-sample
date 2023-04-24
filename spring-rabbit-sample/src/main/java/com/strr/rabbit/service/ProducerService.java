package com.strr.rabbit.service;

import com.strr.rabbit.config.RabbitFanoutConfig;
import com.strr.rabbit.config.RabbitHeaderConfig;
import com.strr.rabbit.config.RabbitTopicConfig;
import com.strr.rabbit.model.Foo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDirect() {
        rabbitTemplate.convertAndSend("hello-queue", new Foo("hello direct!"));
    }

    public void sendFanout() {
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME, null, new Foo("hello fanout!"));
    }

    public void sendTopic() {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "topic1.aaa", new Foo("hello topic1!"));
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "topic2.bbb", new Foo("hello topic2!"));
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "topic3.ccc", new Foo("hello topic3!"));
    }

    public void sendHeader() {
        Message nameMsg = MessageBuilder.withBody("hello header! name-queue".getBytes())
                .setHeader("name", "strr").build();
        Message ageMsg = MessageBuilder.withBody("hello header! age-queue".getBytes())
                .setHeader("age", "99").build();
        rabbitTemplate.convertAndSend(RabbitHeaderConfig.HEADERNAME, null, nameMsg);
        rabbitTemplate.convertAndSend(RabbitHeaderConfig.HEADERNAME, null, ageMsg);
    }
}
