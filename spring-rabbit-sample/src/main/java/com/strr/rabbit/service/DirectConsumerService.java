package com.strr.rabbit.service;

import com.strr.rabbit.model.Foo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DirectConsumerService {
    private final Logger logger = LoggerFactory.getLogger(DirectConsumerService.class);

    @RabbitListener(queues = "hello-queue")
    public void listen(Foo foo) {
        logger.info("Received: " + foo);
    }
}
