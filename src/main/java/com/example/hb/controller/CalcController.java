package com.example.hb.controller;

import com.example.hb.service.LotteryHistoryService;
import com.example.hb.service.LotteryStandardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalcController.class);

    @Autowired
    LotteryHistoryService lotteryHistoryService;

    @Autowired
    LotteryStandardService lotteryStandardService;

    /**
     * 计算所有期望值并保存
     */
    @RequestMapping("/allExp")
    public String allExpectedValue() {
        try {
            LOGGER.info("[计算所有期望值]开始......");
            lotteryHistoryService.setExpectedValue();
            return "计算成功！";
        } catch (Exception e) {
            LOGGER.error("[计算所有期望值]异常：", e);
            return "系统异常";
        }
    }

    /**
     * 计算历史各项数值并保存
     */
    @RequestMapping("/historyData")
    public String historyData() {
        try {
            LOGGER.info("[计算历史各项数据]开始......");
            lotteryStandardService.calcHistory();
            return "计算成功！";
        } catch (Exception e) {
            LOGGER.error("[计算历史各项数据]异常：", e);
            return "系统异常";
        }
    }

    /**
     * 计算组合各项数值并保存
     */
    @RequestMapping("/combinationData")
    public String combinationData() {
        try {
            LOGGER.info("[计算组合各项数据]开始......");
            lotteryStandardService.calcCombin();
            return "计算成功！";
        } catch (Exception e) {
            LOGGER.error("[计算组合各项数据]异常：", e);
            return "系统异常";
        }
    }
}
