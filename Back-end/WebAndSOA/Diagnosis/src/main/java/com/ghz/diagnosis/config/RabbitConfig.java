package com.ghz.diagnosis.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Gu HungJou
 * @date: 2022/5/11 12:49
 * Describe:
 */
@Configuration
public class RabbitConfig {
    //simple模式
    @Bean
    public Queue getQueue() {
        return new Queue("springboot-simple-queue", true, false, false);
    }
}
