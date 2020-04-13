package com.omega.demo.rest.controller;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 2020/4/13
 * @Time 16:45
 */
@CacheConfig(cacheNames = {"demoController"}, keyGenerator = "myKeygenerator")
@RestController
public class DemoController {

    @Cacheable(condition = "#id>1")
    @GetMapping(value = "/get/{id}")
    public Object get(@PathVariable(value = "id") Integer id) {
        System.out.println(id);
        return id;
    }

    @CacheEvict(allEntries = true)
    @GetMapping(value = "/delete/{id}")
    public Object delete(@PathVariable(value = "id") Integer id) {
        return id;
    }

}
