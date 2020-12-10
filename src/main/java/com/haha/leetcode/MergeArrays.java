package com.haha.leetcode;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 */
public class MergeArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums1_end = m - 1;
        int nums2_end = n - 1;
        int end = m + n - 1;


        while (nums1_end >= 0 && nums2_end >= 0) {
            //比较两个数组最后一个数,将较大的数，放在nums1的尾部。
            if (nums1[nums1_end] > nums2[nums2_end]) {
                nums1[end] = nums1[nums1_end];
                nums1_end--;
            } else {
                nums1[end] = nums2[nums2_end];
                nums2_end--;
            }
            end--;
        }

        //处理剩余的数据
        while (nums1_end >= 0) {
            nums1[end] = nums1[nums1_end];
            nums1_end--;
            end--;
        }
        while (nums2_end >= 0) {
            nums1[end] = nums2[nums2_end];
            nums2_end--;
            end--;
        }

    }
}
