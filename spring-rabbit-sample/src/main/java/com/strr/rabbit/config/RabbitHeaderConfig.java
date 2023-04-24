package com.strr.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitHeaderConfig {
    public final static String HEADERNAME = "strr-header";

    @Bean
    protected HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERNAME, true, false);
    }

    @Bean
    protected Queue queueName() {
        return new Queue("name-queue");
    }

    @Bean
    protected Queue queueAge() {
        return new Queue("age-queue");
    }

    @Bean
    protected Binding bindingName() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "strr");
        return BindingBuilder.bind(queueName())
                .to(headersExchange()).whereAny(map).match();
    }

    @Bean
    protected Binding bindingAge() {
        return BindingBuilder.bind(queueAge())
                .to(headersExchange()).where("age").exists();
    }
}
