package com.strr.kafka.service;

import com.strr.kafka.model.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendFoo(String what) {
        kafkaTemplate.send("topic1", new Foo1(what));
    }
}
