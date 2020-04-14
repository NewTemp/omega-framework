package com.omega.demo.rest.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 2020/4/14
 * @Time 12:32
 */
@RestController
public class RabbitMqController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/set/{content}")
    public Object sendMessage(@PathVariable(value = "content") String content) {

        rabbitTemplate.convertAndSend("amqpadmin.exchange", "llhRoughtKey", content);

        return content;
    }
}
