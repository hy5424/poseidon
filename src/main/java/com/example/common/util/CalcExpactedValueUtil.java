package com.example.common.util;

import com.example.entity.LotteryHistory;

import java.math.BigDecimal;

/**
 * 计算期望值
 */
public class CalcExpactedValueUtil {

    /**
     * 计算单个期望值
     *
     * @param lotteryHistory
     * @return
     */
    public static Double calcExpectedValue(LotteryHistory lotteryHistory) {

        Double firstPrizeAmount = lotteryHistory.getFirstPrizeAmount();
        Double secondPrizeAmount = lotteryHistory.getSecondPrizeAmount();
        Double thirdPrizeAmount = lotteryHistory.getThirdPrizeAmount();
        Long firstPrizeCount = lotteryHistory.getFirstPrizeCount();
        Long secondPrizeCount = lotteryHistory.getSecondPrizeCount();
        Long thirdPrizeCount = lotteryHistory.getThirdPrizeCount();

        Long salesVolume = lotteryHistory.getSales().longValue() / 2;

        Double firstExp = new BigDecimal(firstPrizeAmount).multiply(new BigDecimal(firstPrizeCount)).divide(new BigDecimal(salesVolume), 20, BigDecimal.ROUND_HALF_UP).doubleValue();
        Double secondExp = new BigDecimal(secondPrizeAmount).multiply(new BigDecimal(secondPrizeCount)).divide(new BigDecimal(salesVolume), 20, BigDecimal.ROUND_HALF_UP).doubleValue();
        Double thirdExp = new BigDecimal(thirdPrizeAmount).multiply(new BigDecimal(thirdPrizeCount)).divide(new BigDecimal(salesVolume), 20, BigDecimal.ROUND_HALF_UP).doubleValue();

        Double expectedValue = firstExp + secondExp + thirdExp;

        return expectedValue;
    }
}
