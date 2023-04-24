package com.strr.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {
    public final static String TOPICNAME = "strr-topic";

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }

    @Bean
    Queue queue1() {
        return new Queue("topic1-queue");
    }
    @Bean
    Queue queue2() {
        return new Queue("topic2-queue");
    }
    @Bean
    Queue queue3() {
        return new Queue("topic3-queue");
    }

    @Bean
    Binding queue1Binding() {
        return BindingBuilder.bind(queue1()).to(topicExchange())
                .with("topic1.#");
    }
    @Bean
    Binding queue2Binding() {
        return BindingBuilder.bind(queue2()).to(topicExchange())
                .with("topic2.#");
    }
    @Bean
    Binding queue3Binding() {
        return BindingBuilder.bind(queue3()).to(topicExchange())
                .with("topic3.#");
    }
}
