package com.haha.leetcode;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class MySqrt {


    public int mySqrt(int x) {

        if (x <= 1) {
            return 1;
        }

        int low = 1;
        int high = x;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int sqrt = x / middle;
            if (sqrt == middle) {
                return middle;
            } else if (sqrt > middle) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        //因为结束条件为low>high,因此high更小
        return high;

    }
}
