package com.omega.demo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan(basePackages = {"com.omega.*"})
@EnableAsync
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableCaching
@EnableScheduling
@SpringBootApplication
//@EnableConfigurationProperties({ElasticSearchConfig.class})
public class OmegaScDemoRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmegaScDemoRestApplication.class, args);
    }
}
