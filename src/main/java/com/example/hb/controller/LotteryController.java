package com.example.hb.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.LotteryHistory;
import com.example.hb.repository.LotteryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    LotteryHistoryRepository lotteryHistoryRepository;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/getAll")
    public String lotteryHistory() {
        if (redisTemplate.hasKey("lotteryList")) {
            List<LotteryHistory> list = redisTemplate.opsForList().range("lotteryList", 0, -1);
            return JSON.toJSONString(list);
        } else {
            Iterable<LotteryHistory> iterable = lotteryHistoryRepository.findAll();
            List<LotteryHistory> list = new ArrayList<>();
            iterable.forEach(single -> {
                list.add(single);
            });
            redisTemplate.opsForList().rightPushAll("lotteryList", list);
            return JSON.toJSONString(list);
        }
    }
}
