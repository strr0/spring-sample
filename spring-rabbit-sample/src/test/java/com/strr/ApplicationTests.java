package com.strr;

import com.strr.rabbit.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private ProducerService producerService;

    @Test
    void sendDirectTest() {
        producerService.sendDirect("hello-queue", "hello world!");
    }

    @Test
    void sendFanoutTest() {
        producerService.sendFanout("hello fanout!");
    }

    @Test
    void sendTopicTest() {
        producerService.sendTopic("topic1.aa", "hello topic1!");
        producerService.sendTopic("topic2.bb", "hello topic2!");
        producerService.sendTopic("topic3.cc", "hello topic3!");
    }

    @Test
    void sendHeaderTest() {
        Message nameMsg = MessageBuilder.withBody("hello header! name-queue".getBytes())
                .setHeader("name", "strr").build();
        Message ageMsg = MessageBuilder.withBody("hello header! age-queue".getBytes())
                .setHeader("age", "99").build();
        producerService.sendHeader(nameMsg);
        producerService.sendHeader(ageMsg);
    }
}
