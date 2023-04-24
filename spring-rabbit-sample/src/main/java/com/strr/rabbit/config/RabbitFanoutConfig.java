package com.strr.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitFanoutConfig {
    public final static String FANOUTNAME = "strr-fanout";

    @Bean
    protected FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUTNAME, true, false);
    }

    @Bean
    protected Queue queueOne() {
        return new Queue("queue-one");
    }

    @Bean
    protected Queue queueTwo() {
        return new Queue("queue-two");
    }

    @Bean
    protected Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }

    @Bean
    protected Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }
}
