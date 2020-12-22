package com.haha.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 请找出其中最小的元素。
 */
public class FindMin {

    public int findMin(int[] nums) {
        //特判
        if (nums.length <= 1) {
            return nums[0];
        }

        //以第一个元素作为基准元素
        int template = nums[0];
        int low = 1;
        int high = nums.length - 1;

        while (low < high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] > template) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return nums[low];
    }
}
