package com.haha.leetcode;

import javax.sound.midi.Soundbank;

/**
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
    }

    public void sortColors(int[] nums) {
        //定义两个指针
        int ptr0 = 0; //代表可以填0的下标位置
        int ptr1 = 0; //代表可以填1的下标位置

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                //如果是0，则交换位置
                swap(nums, i, ptr0);
                //如果ptr1在ptr0前面，则交换出去的为1，要重新放在ptr1的位置
                if (ptr1 > ptr0) {
                    swap(nums, i, ptr1);
                }
                ptr0++;
                ptr1++;
            } else if (nums[i] == 1) {
                //如果是1，直接交换位置
                swap(nums, i, ptr1);
                ptr1++;
            }

        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
