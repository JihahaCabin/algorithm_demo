package com.haha.leetcode;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];
        //循环nums,进行平方
        for (int i = 0; i < nums.length; i++) {
            //进行平方
            int square = nums[i] * nums[i];
            result[i] = square;
            //前面的总为有序,找到应该插入的位置
            for (int j = i; j >= 0; j--) {
                if (j - 1 >= 0) {
                    //如果前面的数，大于square,则后移
                    if (result[j - 1] > square) {
                        int temp = result[j];
                        result[j] = result[j - 1];
                        result[j - 1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
