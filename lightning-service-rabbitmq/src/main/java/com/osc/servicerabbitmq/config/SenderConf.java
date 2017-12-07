package com.osc.servicerabbitmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

/**
 * @description: SenderConf
 * @author: lizhiming
 * @since: 2017/12/7
 */
@Configuration
public class SenderConf {

    private static Logger LOGGER = LoggerFactory.getLogger(SenderConf.class);

    @Bean
    public Queue queue() {
        LOGGER.info("【RabbitMQ】配置>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return new Queue("queue");
    }
}
