package com.strr.rabbit.service;

import com.strr.rabbit.model.Foo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FanoutConsumerService {
    private final Logger logger = LoggerFactory.getLogger(FanoutConsumerService.class);

    @RabbitListener(queues = "queue-one")
    public void listen1(Foo foo) {
        logger.info("Received[queue-one]: " + foo);
    }

    @RabbitListener(queues = "queue-two")
    public void listen2(Foo foo) {
        logger.info("Received[queue-two]: " + foo);
    }
}
