package com.example.common.util;

import com.example.entity.LotteryHistory;

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

        Double expectedValue = firstPrizeAmount * (firstPrizeCount / salesVolume)
                + secondPrizeAmount * (secondPrizeCount / salesVolume)
                + thirdPrizeAmount * (thirdPrizeCount / salesVolume);

        return expectedValue;
    }
}
