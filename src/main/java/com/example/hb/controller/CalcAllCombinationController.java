package com.example.hb.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.util.CalcUtil;
import com.example.entity.LotteryCombination;
import com.example.hb.repository.LotteryCombinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CalcAllCombinationController {

    public static JedisPoolConfig conf = new JedisPoolConfig();
    public static JedisPool pool = new JedisPool(conf, "localhost", 6379,
            100000);
    public static Jedis jedis = pool.getResource();

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    LotteryCombinationRepository lotteryCombinationRepository;

    @PersistenceContext
    protected EntityManager em;


    /**
     * 这里分成多部分处理
     * 第一次循环上限 list.size / 2
     * 第二次循环上限 list.size()
     * 不分开处理会内存溢出
     * 同时使用EntityManager来处理数据库事务
     * 执行flush是保存到数据库
     *
     * @return
     */
    @Transactional
    @RequestMapping("/save/combination")
    public String add() {
        List<int[]> list = CalcUtil.calcAllCombination();

        List<LotteryCombination> eList = new ArrayList<>();
        LotteryCombination lotteryCombination = null;
        for (int i = 0; i < list.size() / 2; i++) {
            lotteryCombination = new LotteryCombination();
            int[] x = list.get(i);
            lotteryCombination.setBlue1(x[0]);
            lotteryCombination.setBlue2(x[1]);
            lotteryCombination.setBlue3(x[2]);
            lotteryCombination.setBlue4(x[3]);
            lotteryCombination.setBlue5(x[4]);
            lotteryCombination.setBlue6(x[5]);
            lotteryCombination.setRed(x[6]);
            eList.add(lotteryCombination);
        }
        System.out.println("开始插入......");

        for (int j = 0; j < eList.size(); j++) {
            long startTime = System.currentTimeMillis();
            em.persist(eList.get(j));
            if (j % 100000 == 0) {
                em.flush();
                em.clear();
                long endTime = System.currentTimeMillis(); // 获取结束时间
                System.out.println("插入100000条数据时间： " + (endTime - startTime) + "ms");
            }
        }

        return "插入数据库成功！";
    }


    /**
     * 缓存查询
     *
     * @return
     */
    @RequestMapping("/queryAllCombination")
    public String calcAllCombination() {
        if (redisTemplate.hasKey("combination")) {
            List<int[]> list = redisTemplate.opsForList().range("combination", 0, -1);
            return "缓存查询成功：" + list.size();
        } else {
            Pipeline p = jedis.pipelined();
            List<int[]> list = CalcUtil.calcAllCombination();
            for (int i = 0; i < list.size() / 2; i++) {
                p.rpush("combination", JSON.toJSONString(list.get(i)));
            }
            p.sync();
            jedis.close();
            return "直接查询成功：" + list.size();
        }
    }
}
