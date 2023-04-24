package com.strr.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitDirectConfig {
    public final static String DIRECTNAME = "strr-direct";

    @Bean
    protected Queue queue() {
        return new Queue("hello-queue");
    }

    @Bean
    protected DirectExchange directExchange() {
        return new DirectExchange(DIRECTNAME, true, false);
    }

    @Bean
    protected Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}
