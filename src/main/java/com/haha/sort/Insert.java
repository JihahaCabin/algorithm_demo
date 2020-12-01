package com.haha.sort;

import com.haha.common.CommonTool;

import java.util.Arrays;

/**
 * 插入排序
 * 前面的元素永远有序，将后面的元素取出，逐个与之前的元素比较大小，交换位置，知道元素找到其有序的位置位置
 * 时间复杂度为O(n^2)
 */
public class Insert {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 7, 2, 76, 98, 23, 456, 2};
        System.out.println(Arrays.toString(arr));
        Insert.sort(arr);
        // 输出结果
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] arr) {
        //i表示需要比较的那个元素
        for (int i = 1; i < arr.length; i++) {
            //arr[0]到arr[j]表示有序的元素
            for (int j = i - 1; j >= 0; j--) {
                //如果j+1的元素小于j的元素，则交换位置
                if (CommonTool.greater(arr[j], arr[j + 1])) {
                    CommonTool.exchange(arr, j + 1, j);
                } else {
                    //如果遇到不小于j的元素，证明已经找到位置了，直接跳出
                    break;
                }
            }
        }
    }
}
