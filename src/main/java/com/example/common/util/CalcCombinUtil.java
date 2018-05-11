package com.example.common.util;

import org.hibernate.annotations.LazyToOne;

/**
 * 计算组合数
 */
public class CalcCombinUtil {

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
}
