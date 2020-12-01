package com.haha.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 循环N*(N-1)/2次，因此时间复杂度为O(n^2)
 */
public class Bubble {

    public static void main(String[] args) {
        Integer[] arr = {4, 5, 7, 2, 76, 98, 23, 456, 2};
        System.out.println(Arrays.toString(arr));
        Bubble.sort(arr);
        // 输出结果
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] arr) {
        //size表示用于对比的第二个元素取值范围
        for (int size = arr.length; size > 0; size--) {
            for (int i = 0; i < size - 1; i++) {
                //如果第一个元素比后一个元素要大，则交换位置
                if (greater(arr[i], arr[i + 1])) {
                    exchange(arr, i, i + 1);
                }
            }
        }
    }


    //比较C1是否大于C2
    private static boolean greater(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        return result > 0;
    }

    //交换下标i和j的元素
    private static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
