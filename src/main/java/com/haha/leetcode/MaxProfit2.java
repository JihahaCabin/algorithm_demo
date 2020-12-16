package com.haha.leetcode;

/**
 * 动态规划
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {

        //特判
        if (prices.length == 0) {
            return 0;
        }

        //使用一个二维数组，数组中的每一个元素，第一个为没有股票的利润，第二个为拥有股票的利润
        int[][] profit = new int[prices.length][2];
        //状态转移方程为
        // f[i][0] = max(f[i-1][0], (f[i-1][1]+prices[i]) )  //上一天没有股票，或者上一天有股票，但是今天卖出
        // f[i][1] = max(f[i-1][1],f[i-1][0]-prices[i]) //上一天有股票，或者上一天没有股票，今天买入

        //定义初始值
        profit[0][0] = 0;
        profit[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], (profit[i - 1][1] + prices[i]));
            profit[i][1] = Math.max(profit[i - 1][1], (profit[i - 1][0] - prices[i]));
        }

        //最后一天没有股票最多利润
        return profit[prices.length - 1][0];
    }
}
