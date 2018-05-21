package com.example.hb.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.LotteryHistory;
import com.example.hb.service.LotteryHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);

    @Autowired
    LotteryHistoryService lotteryHistoryService;

    /**
     * 获取历史记录
     *
     * @return
     */
    @RequestMapping("/getAll")
    public String lotteryHistory() {
        try {
            LOGGER.info("[获得历史记录]开始......");
            List<LotteryHistory> list = lotteryHistoryService.getAll();
            return JSON.toJSONString(list);
        } catch (Exception e) {
            LOGGER.error("[获得历史记录]异常：", e);
            return "系统异常";
        }
    }
}
