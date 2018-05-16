package com.example.hb.controller;

import com.example.hb.service.LotteryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class ExpectedValueController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpectedValueController.class);

    @Autowired
    LotteryService lotteryService;

    /**
     * 计算所有期望值并保存
     */
    @RequestMapping("/allExp")
    public String allExpectedValue() {
        try {
            LOGGER.info("[计算所有期望值]开始......");
            lotteryService.setExpectedValue();
            return "计算成功！";
        } catch (Exception e) {
            LOGGER.error("[计算所有期望值]异常：", e);
            return "系统异常";
        }
    }
}
