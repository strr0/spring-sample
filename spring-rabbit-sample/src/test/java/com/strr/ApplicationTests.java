package com.strr;

import com.strr.rabbit.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private ProducerService producerService;

    @Test
    void sendDirectTest() {
        producerService.sendDirect();
    }

    @Test
    void sendFanoutTest() {
        producerService.sendFanout();
    }

    @Test
    void sendTopicTest() {
        producerService.sendTopic();
    }

    @Test
    void sendHeaderTest() {
        producerService.sendHeader();
    }
}
