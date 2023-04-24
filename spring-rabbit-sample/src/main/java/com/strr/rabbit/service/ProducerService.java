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

    public void sendDirect(String key, String what) {
        rabbitTemplate.convertAndSend(key, new Foo(what));
    }

    public void sendFanout(String what) {
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME, null, new Foo(what));
    }

    public void sendTopic(String key, String what) {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, key, new Foo(what));
    }

    public void sendHeader(Message message) {
        rabbitTemplate.convertAndSend(RabbitHeaderConfig.HEADERNAME, null, message);
    }
}
