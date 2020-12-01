package com.haha.sort;

import com.haha.common.CommonTool;

import java.util.Arrays;

/**
 * 选择算法
 * 每次遍历，找到当前范围内最小的元素
 * 将该元素放在"遍历范围"的第一个位置，再缩小范围，继续排序
 * 时间复杂度为O(n^2)，比冒泡排序好一点，不用每次都交换
 */
public class Selection {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 7, 2, 76, 98, 23, 456, 2};
        System.out.println(Arrays.toString(arr));
        Selection.sort(arr);
        // 输出结果
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(Comparable[] arr) {
        //i表示"遍历范围"的第一个位置下标
        for (int i = 0; i < arr.length - 1; i++) {
            //假设遍历范围的第一个元素为最小元素
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //如果minIndex的元素较大，则将minIndex记录为j
                if (CommonTool.greater(arr[minIndex], arr[j])) {
                    minIndex = j;
                }
            }
            //找到本次循环的最小元素后，与"遍历范围"的第一个位置的元素交换
            CommonTool.exchange(arr, minIndex, i);
        }
    }
}
