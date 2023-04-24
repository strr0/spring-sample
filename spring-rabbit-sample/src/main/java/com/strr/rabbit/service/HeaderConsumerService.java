package com.strr.rabbit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HeaderConsumerService {
    private final Logger logger = LoggerFactory.getLogger(HeaderConsumerService.class);

    @RabbitListener(queues = "name-queue")
    public void handler1(byte[] msg) {
        logger.info("Received[name]: " + new String(msg, 0, msg.length));
    }

    @RabbitListener(queues = "age-queue")
    public void handler2(byte[] msg) {
        logger.info("Received[age]: " + new String(msg, 0, msg.length));
    }
}
