package com.example.common.util;

import com.example.entity.LotteryHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 计算期望值
 */
public class CalcUtil {

    private static final int[] red = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};
    private static final int[] blue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    private static List<int[]> list = new ArrayList<>();

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 拿到所有的组合
     */
    public static List<int[]> calcAllCombination() {
        combinationSelect(red, 6);
        return list;
    }

    /**
     * 组合选择（从列表中选择n个组合）
     *
     * @param dataList 待选列表
     * @param n        选择个数
     */
    private static void combinationSelect(int[] dataList, int n) {
        combinationSelect(dataList, 0, new int[n + 1], 0);
    }

    /**
     * 组合选择
     *
     * @param dataList    待选列表
     * @param dataIndex   待选开始索引
     * @param resultList  前面（resultIndex-1）个的组合结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void combinationSelect(int[] dataList, int dataIndex, int[] resultList, int resultIndex) {
        int resultLen = resultList.length - 1;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
            int[] resultArray = null;
            for (int blue : blue) {
                resultArray = new int[7];
                resultList[6] = blue;
                for (int i = 0; i < resultList.length; i++) {
                    resultArray[i] = resultList[i];
                }
                list.add(resultArray);
            }
            return;
        }

        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);
        }
    }

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

    /**
     * 计算所有组合
     *
     * @return
     */
    public static Long calcCombin() {
        Long redc = 33 * 32 * 31 * 30 * 29 * 28L / (getNFactorial(6));
        Long bluec = 16L;
        Long combin = redc * bluec;
        return combin;
    }

    /**
     * 递归求阶乘
     *
     * @param n
     * @return
     */
    public static long getNFactorial(int n) {
        if (n == 0) {
            return 1l;
        }
        return n * getNFactorial(n - 1);
    }

    /**
     * 计算均值
     *
     * @param x
     * @return
     */
    public static double avg(double[] x) {
        int m = x.length;
        double sum = 0;
        for (int i = 0; i < m; i++) {//求和
            sum += x[i];
        }
        double dAve = sum / m;//求平均值
        return dAve;
    }

    /**
     * 计算方差
     *
     * @param x
     * @return
     */
    public static double variance(double[] x) {
        int m = x.length;
        double dAve = CalcUtil.avg(x);
        double dVar = 0;
        for (int i = 0; i < m; i++) {//求方差
            dVar += (x[i] - dAve) * (x[i] - dAve);
        }
        return dVar / m;
    }

    /**
     * 计算标准差
     *
     * @param x
     * @return
     */
    public static double standardDiviation(double[] x) {
        int m = x.length;
        double dVar = CalcUtil.variance(x);
        return Math.sqrt(dVar / m);
    }

    /**
     * 计算协方差
     *
     * @param x
     * @param y
     * @return
     */
    public static double covariance(double[] x, double[] y) {
        double x_avg = CalcUtil.avg(x);
        double y_avg = CalcUtil.avg(y);
        double covSum = 0;
        for (int i = 0; i < x.length; i++) {
            covSum += (x[i] - x_avg) * (y[i] - y_avg);
        }
        return covSum / (x.length - 1);
    }

    /**
     * 快速排序
     *
     * @param data
     */
    public static void quickSort(int[] data) {
        if (data.length > 0) {
            quickSort(data, 0, data.length - 1);
        }
    }

    /**
     * 快排算法
     *
     * @param a
     * @param low
     * @param high
     */
    private static void quickSort(int[] a, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int key = a[low];
        while (i < j) {
            while (i < j && a[j] > key) {
                j--;
            }
            while (i < j && a[i] <= key) {
                i++;
            }
            if (i < j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        quickSort(a, low, i - 1);
        quickSort(a, i + 1, high);
    }
}
