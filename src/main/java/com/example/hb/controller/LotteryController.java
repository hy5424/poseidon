package com.example.hb.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.LotteryHistory;
import com.example.hb.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    LotteryService lotteryService;

    @RequestMapping("/getAll")
    public String lotteryHistory() {
        List<LotteryHistory> list = lotteryService.getAll();
        return JSON.toJSONString(list);
    }
}
