package com.haha.leetcode;

/**
 * 540. 有序数组中的单一元素
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
 */
public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        /**
         * ：仅对偶数索引进行二分搜索
         * 我们需要确保 mid 是偶数，如果为奇数，则将其减 1。
         * 然后，我们检查 mid 的元素是否与其后面的索引相同。
         * 如果相同，则我们知道 mid 不是单个元素。且单个元素在 mid 之后。则我们将 lo 设置为 mid + 2。
         * 如果不是，则我们知道单个元素位于 mid，或者在 mid 之前。我们将 hi 设置为 mid。
         * 一旦 lo == hi，则当前搜索空间为 1 个元素，那么该元素为单个元素，我们将返回它。
         */
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (middle % 2 != 0) {
                middle--;
            }
            if (nums[middle] == nums[middle + 1]) {
                low = middle + 2;
            } else {
                high = middle;
            }

        }

        return nums[low];
    }
}
