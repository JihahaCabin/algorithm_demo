package com.haha.leetcode;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //当前卖出时的最大利润
            int thisProfit = prices[i] - min;
            //比较之前卖出的利润，记录最大利润
            if (thisProfit > profit) {
                profit = thisProfit;
            }

            //记录当前为止的最小值
            if (prices[i] < min) {
                min = prices[i];
            }
        }


        return profit;
    }
}
