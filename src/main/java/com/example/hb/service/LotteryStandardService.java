package com.example.hb.service;

import com.example.common.util.CalcUtil;
import com.example.entity.LotteryHistory;
import com.example.entity.LotteryStandard;
import com.example.hb.repository.LotteryCombinationRepository;
import com.example.hb.repository.LotteryHistoryRepository;
import com.example.hb.repository.LotteryStandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LotteryStandardService {

    @Autowired
    LotteryStandardRepository lotteryStandardRepository;

    @Autowired
    LotteryHistoryRepository lotteryHistoryRepository;

    @Autowired
    LotteryCombinationRepository lotteryCombinationRepository;

    /**
     * 计算历史记录各项数值
     */
    public void calcHistory() {
        Iterable<LotteryHistory> iterable = lotteryHistoryRepository.findAll();
        List<LotteryHistory> list = new ArrayList<>();
        iterable.forEach(single -> {
            list.add(single);
        });

        double[] b1Avg = new double[list.size()];
        double[] b1Variance = new double[list.size()];
        double[] b1StandardDiviation = new double[list.size()];
        double[] b1Ccovariance = new double[list.size()];

        double[] b2Avg = new double[list.size()];
        double[] b2Variance = new double[list.size()];
        double[] b2StandardDiviation = new double[list.size()];
        double[] b2Ccovariance = new double[list.size()];

        double[] b3Avg = new double[list.size()];
        double[] b3Variance = new double[list.size()];
        double[] b3StandardDiviation = new double[list.size()];
        double[] b3Ccovariance = new double[list.size()];

        double[] b4Avg = new double[list.size()];
        double[] b4Variance = new double[list.size()];
        double[] b4StandardDiviation = new double[list.size()];
        double[] b4Ccovariance = new double[list.size()];

        double[] b5Avg = new double[list.size()];
        double[] b5Variance = new double[list.size()];
        double[] b5StandardDiviation = new double[list.size()];
        double[] b5Ccovariance = new double[list.size()];

        double[] b6Avg = new double[list.size()];
        double[] b6Variance = new double[list.size()];
        double[] b6StandardDiviation = new double[list.size()];
        double[] b6Ccovariance = new double[list.size()];

        double[] rAvg = new double[list.size()];
        double[] rVariance = new double[list.size()];
        double[] rStandardDiviation = new double[list.size()];
        double[] rCcovariance = new double[list.size()];

        for (int i = 0; i < list.size(); i++) {
            b1Avg[i] = list.get(i).getBlue1();
            b1Variance[i] = list.get(i).getBlue1();
            b1StandardDiviation[i] = list.get(i).getBlue1();
            b1Ccovariance[i] = list.get(i).getBlue1();

            b2Avg[i] = list.get(i).getBlue2();
            b2Variance[i] = list.get(i).getBlue2();
            b2StandardDiviation[i] = list.get(i).getBlue2();
            b2Ccovariance[i] = list.get(i).getBlue2();

            b3Avg[i] = list.get(i).getBlue3();
            b3Variance[i] = list.get(i).getBlue3();
            b3StandardDiviation[i] = list.get(i).getBlue3();
            b3Ccovariance[i] = list.get(i).getBlue3();

            b4Avg[i] = list.get(i).getBlue4();
            b4Variance[i] = list.get(i).getBlue4();
            b4StandardDiviation[i] = list.get(i).getBlue4();
            b4Ccovariance[i] = list.get(i).getBlue4();

            b5Avg[i] = list.get(i).getBlue5();
            b5Variance[i] = list.get(i).getBlue5();
            b5StandardDiviation[i] = list.get(i).getBlue5();
            b5Ccovariance[i] = list.get(i).getBlue5();

            b6Avg[i] = list.get(i).getBlue6();
            b6Variance[i] = list.get(i).getBlue6();
            b6StandardDiviation[i] = list.get(i).getBlue6();
            b6Ccovariance[i] = list.get(i).getBlue6();

            rAvg[i] = list.get(i).getRed();
            rVariance[i] = list.get(i).getRed();
            rStandardDiviation[i] = list.get(i).getRed();
            rCcovariance[i] = list.get(i).getRed();
        }

        LotteryStandard lotteryStandard = new LotteryStandard();
        lotteryStandard.setId(1L);
        //计算均值
        lotteryStandard.setHistoryBlue1Avg(CalcUtil.avg(b1Avg));
        lotteryStandard.setHistoryBlue2Avg(CalcUtil.avg(b2Avg));
        lotteryStandard.setHistoryBlue3Avg(CalcUtil.avg(b3Avg));
        lotteryStandard.setHistoryBlue4Avg(CalcUtil.avg(b4Avg));
        lotteryStandard.setHistoryBlue5Avg(CalcUtil.avg(b5Avg));
        lotteryStandard.setHistoryBlue6Avg(CalcUtil.avg(b6Avg));
        lotteryStandard.setHistoryRedAvg(CalcUtil.avg(rAvg));
        //计算方差
        lotteryStandard.setHistoryBlue1Variance(CalcUtil.variance(b1Variance));
        lotteryStandard.setHistoryBlue2Variance(CalcUtil.variance(b2Variance));
        lotteryStandard.setHistoryBlue3Variance(CalcUtil.variance(b3Variance));
        lotteryStandard.setHistoryBlue4Variance(CalcUtil.variance(b4Variance));
        lotteryStandard.setHistoryBlue5Variance(CalcUtil.variance(b5Variance));
        lotteryStandard.setHistoryBlue6Variance(CalcUtil.variance(b6Variance));
        lotteryStandard.setHistoryRedVariance(CalcUtil.variance(rVariance));
        //计算标准差
        lotteryStandard.setHistoryBlue1StandardDiviation(CalcUtil.standardDiviation(b1StandardDiviation));
        lotteryStandard.setHistoryBlue2StandardDiviation(CalcUtil.standardDiviation(b2StandardDiviation));
        lotteryStandard.setHistoryBlue3StandardDiviation(CalcUtil.standardDiviation(b3StandardDiviation));
        lotteryStandard.setHistoryBlue4StandardDiviation(CalcUtil.standardDiviation(b4StandardDiviation));
        lotteryStandard.setHistoryBlue5StandardDiviation(CalcUtil.standardDiviation(b5StandardDiviation));
        lotteryStandard.setHistoryBlue6StandardDiviation(CalcUtil.standardDiviation(b6StandardDiviation));
        lotteryStandard.setHistoryRedStandardDiviation(CalcUtil.standardDiviation(rStandardDiviation));

        lotteryStandardRepository.save(lotteryStandard.getId());

    }

    /**
     * 计算所有组合各项数值
     */
    public void calcCombin() {

    }
}
