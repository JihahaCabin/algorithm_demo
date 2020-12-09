package com.haha.leetcode;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 * 使用双指针，当和大于目标数，则移动大指针，当和小于目标数，移动小指针
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
