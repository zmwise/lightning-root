package com.osc.servicerabbitmq.receiver;

import com.osc.servicerabbitmq.config.SenderConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description: Receiver
 * @author: lizhiming
 * @since: 2017/12/7
 */
@Component
public class Receiver {

    private static Logger LOGGER = LoggerFactory.getLogger(SenderConf.class);

    @RabbitListener(queues = "queue")
    public void process(String str) {
        LOGGER.info("【RabbitMQ】接收消息 内容>>"+str);
    }

}
