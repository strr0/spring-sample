package com.strr;

import com.strr.kafka.service.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    void sendMessageTest() {
        String what = "hello world!";
        kafkaProducerService.sendFoo(what);
    }
}
