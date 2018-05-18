package com.example.hb.service;

import com.example.common.util.CalcUtil;
import com.example.entity.LotteryHistory;
import com.example.hb.repository.LotteryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LotteryService {

    @Autowired
    LotteryHistoryRepository lotteryHistoryRepository;

    /**
     * 获得历史记录
     *
     * @return
     */
    public List<LotteryHistory> getAll() throws Exception {
        Iterable<LotteryHistory> iterable = lotteryHistoryRepository.findAll();
        List<LotteryHistory> list = new ArrayList<>();
        iterable.forEach(single -> {
            list.add(single);
        });
        return list;
    }


    /**
     * 计算期望值
     */
    public void setExpectedValue() throws Exception {
        List<LotteryHistory> list = this.getAll();
        for (LotteryHistory lotteryHistory : list) {
            Double expectedValue = CalcUtil.calcExpectedValue(lotteryHistory);
            lotteryHistory.setExpectedValue(expectedValue);
        }
        lotteryHistoryRepository.saveAll(list);
    }
}
