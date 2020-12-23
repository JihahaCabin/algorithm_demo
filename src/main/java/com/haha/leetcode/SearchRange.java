package com.haha.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        //找到目标元素的第一个元素
        int first = findFirst(nums, target);
        //找到比目标元素大的第一个元素，然后减一，则为最后一个元素
        int last = findFirst(nums, target + 1) - 1;
        //判断是否找到
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            //由于可能只有一个元素，所以要判断下
            return new int[]{first, Math.max(first, last)};
        }
    }

    public int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return low;

    }
}
