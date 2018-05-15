package com.example.hb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping("/redis")
    public void redis(){
        redisTemplate.opsForValue().set("name", "王赛超");
        redisTemplate.opsForValue().set("age", "24");
        redisTemplate.opsForValue().set("address", "河北邯郸");

        System.out.println(redisTemplate.opsForValue().get("age"));
    }
}
