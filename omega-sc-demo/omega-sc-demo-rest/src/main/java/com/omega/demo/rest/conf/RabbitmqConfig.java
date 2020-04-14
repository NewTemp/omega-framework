package com.omega.demo.rest.conf;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 2020/4/14
 * @Time 15:24
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Exchange createExchange() {
        System.out.println("-------------------------createExchange 成功---------------");
        return new DirectExchange("amqpadmin.exchange");
    }

    @Bean
    public Queue createQueue() {
        HashMap<String, Object> arguments = new HashMap<>(4);
        arguments.put("x-message-ttl", 60 * 1000);
        arguments.put("x-dead-letter-exchange", "amqpadmin.exchange");
        arguments.put("x-dead-letter-routing-key", "llhRoughtKey");
        return new Queue("amqpadmin.confirm.queue", true, false, false, arguments);
    }

    @Bean
    public Binding queueExchange(@Qualifier(value = "createQueue") Queue queue, @Qualifier(value = "createExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("llhRoughtKey").noargs();
    }

}
