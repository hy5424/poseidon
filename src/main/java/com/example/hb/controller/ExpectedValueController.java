package com.example.hb.controller;

import com.example.common.util.CalcExpactedValueUtil;
import com.example.entity.LotteryHistory;
import com.example.hb.repository.LotteryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calc")
public class ExpectedValueController {

    @Autowired
    LotteryHistoryRepository lotteryHistoryRepository;

    /**
     * 计算所有期望值并保存
     */
    @RequestMapping("/allExp")
    public void allExpectedValue() {
        Iterable<LotteryHistory> iterable = lotteryHistoryRepository.findAll();
        List<LotteryHistory> list = new ArrayList<>();
        iterable.forEach(single -> {
            list.add(single);
        });
        for (LotteryHistory lotteryHistory : list) {
            Double expectedValue = CalcExpactedValueUtil.calcExpectedValue(lotteryHistory);
            lotteryHistory.setExpectedValue(expectedValue);
        }
        lotteryHistoryRepository.saveAll(list);
    }

    /**
     * 计算单个期望值并保存
     *
     * @param lotteryHistory
     */
    @RequestMapping("/exp")
    @Transactional
    public void expectedValue(LotteryHistory lotteryHistory) {
        Double expectedValue = CalcExpactedValueUtil.calcExpectedValue(lotteryHistory);
        lotteryHistory.setExpectedValue(expectedValue);
        lotteryHistoryRepository.save(lotteryHistory);
    }


}
