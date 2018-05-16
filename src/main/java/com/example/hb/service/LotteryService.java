package com.example.hb.service;

import com.example.entity.LotteryHistory;
import com.example.hb.repository.LotteryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LotteryService {

    @Autowired
    LotteryHistoryRepository lotteryHistoryRepository;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 获得历史记录
     *
     * @return
     */
    public List<LotteryHistory> getAll() {
        if (redisTemplate.hasKey("lotteryList")) {
            List<LotteryHistory> list = redisTemplate.opsForList().range("lotteryList", 0, -1);
            return list;
        } else {
            Iterable<LotteryHistory> iterable = lotteryHistoryRepository.findAll();
            List<LotteryHistory> list = new ArrayList<>();
            iterable.forEach(single -> {
                list.add(single);
            });
            redisTemplate.opsForList().rightPushAll("lotteryList", list);
            return list;
        }
    }
}
