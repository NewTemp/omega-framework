package com.omega.demo.rest.consumer;

import com.alibaba.fastjson.JSONObject;
import com.omega.demo.rest.conf.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 2020/4/14
 * @Time 15:42
 */
public class RabbitMqListener {

    @RabbitListener(queues = "amqpadmin.confirm.queue")
    public void testListener(@Payload JSONObject messages, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        System.out.println(messages);
        channel.basicAck(tag, false);
    }
}
