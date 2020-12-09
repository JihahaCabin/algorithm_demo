package com.haha.leetcode;

/**
 * 双指针
 * 633. 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        //右指针的初始化，使用c的开方，作为右指针
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i < j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                j--;
            } else if (sum < c) {
                i++;
            }
        }

        return false;
    }
}
