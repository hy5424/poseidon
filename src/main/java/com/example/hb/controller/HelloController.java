package com.example.hb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello() {
        String url = "http://localhost:8092/lottery/getAll";
        String ret = restTemplate.postForObject(url, null, String.class);
        return "restTemplate post测试" + ret;
    }
}
