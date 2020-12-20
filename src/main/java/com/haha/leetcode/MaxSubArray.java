package com.haha.leetcode;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];

        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //动态规划
            //如果preSum>0，则加上nums[i]会更大，
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];

            //如果preSum大于当前记录最大值
            if (preSum > maxSum) {
                maxSum = preSum;
            }
        }
        return maxSum;
    }
}
