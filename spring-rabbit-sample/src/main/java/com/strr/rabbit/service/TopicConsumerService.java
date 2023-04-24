package com.strr.rabbit.service;

import com.strr.rabbit.model.Foo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TopicConsumerService {
    private final Logger logger = LoggerFactory.getLogger(TopicConsumerService.class);

    @RabbitListener(queues = "topic1-queue")
    public void listen1(Foo foo) {
        logger.info("Received[topic1]: " + foo);
    }

    @RabbitListener(queues = "topic2-queue")
    public void listen2(Foo foo) {
        logger.info("Received[topic2]: " + foo);
    }

    @RabbitListener(queues = "topic3-queue")
    public void listen3(Foo foo) {
        logger.info("Received[topic3]: " + foo);
    }
}
