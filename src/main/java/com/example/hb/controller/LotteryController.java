package com.example.hb.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.LotteryHistory;
import com.example.hb.repository.LotteryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lottery")
@EnableAutoConfiguration
public class LotteryController {

    @Autowired
    LotteryHistoryRepository lotteryHistoryRepository;

    @RequestMapping("/getAll")
    public String lotteryHistory() {
        Iterable<LotteryHistory> iterable = lotteryHistoryRepository.findAll();
        List<LotteryHistory> list = new ArrayList<>();
        iterable.forEach(single -> {
            list.add(single);
        });
        return JSON.toJSONString(list);
    }
}
