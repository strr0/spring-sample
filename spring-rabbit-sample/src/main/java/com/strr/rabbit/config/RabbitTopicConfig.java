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
    protected TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }

    @Bean
    protected Queue queue1() {
        return new Queue("topic1-queue");
    }

    @Bean
    protected Queue queue2() {
        return new Queue("topic2-queue");
    }

    @Bean
    protected Queue queue3() {
        return new Queue("topic3-queue");
    }

    @Bean
    protected Binding queue1Binding() {
        return BindingBuilder.bind(queue1()).to(topicExchange())
                .with("topic1.#");
    }

    @Bean
    protected Binding queue2Binding() {
        return BindingBuilder.bind(queue2()).to(topicExchange())
                .with("topic2.#");
    }

    @Bean
    protected Binding queue3Binding() {
        return BindingBuilder.bind(queue3()).to(topicExchange())
                .with("topic3.#");
    }
}
