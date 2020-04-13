package com.omega.demo.rest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 2020/4/13
 * @Time 17:24
 */
@Configuration
public class KeyGenerator {


    @Bean("myKeygenerator")
    public org.springframework.cache.interceptor.KeyGenerator keyGenerator() {
        return (o, method, objects) -> method.getClass().getName();
    }

}
