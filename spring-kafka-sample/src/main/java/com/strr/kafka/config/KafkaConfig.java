package com.strr.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
@EnableKafka
public class KafkaConfig {
    @Bean
    public NewTopic topic() {
        return new NewTopic("topic1", 1, (short) 1);
    }

    // 消息转换
    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }
}
