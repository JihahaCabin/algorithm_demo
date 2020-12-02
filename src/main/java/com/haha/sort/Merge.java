package com.haha.sort;

import com.haha.common.CommonTool;

import java.util.Arrays;

/**
 * 归并排序
 * 分而治之，以时间换空间
 * 时间复杂度 O(NlogN)
 * 不断递归分成两个数组，直到只有单个元素，然后再将两个有序数组，合并成一个有序数组
 */
public class Merge {

    public static Comparable[] assistance;

    public static void main(String[] args) {
        Integer[] arr = {4, 5, 7, 2, 76, 98, 23, 456, 1};
        System.out.println(Arrays.toString(arr));
        Merge.sort(arr);
        // 输出结果
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(Comparable[] arr) {
        //初始化辅助数组
        assistance = new Comparable[arr.length];
        //排序起始位置
        int start = 0;
        //排序结束位置
        int end = arr.length - 1;
        //调用排序算法
        sort(arr, start, end);
    }

    private static void sort(Comparable[] arr, int start, int end) {

        //如果end>=start,证明只有一个元素，不需要继续进行
        if (end <= start) {
            return;
        }

        //找到数组中间位置
        int middle = start + (end - start) / 2;
        //将数组分成两部分，对这两个数组进行排序
        sort(arr, start, middle);
        sort(arr, middle + 1, end);
        //将排好序的两个数组，合并成一个数组
        merge(arr, start, middle, end);
    }

    /**
     * 从索引start到middle为一组，从middle+1到end为一组，将两组有序的数组合并成一个有序数组
     *
     * @param arr
     * @param start
     * @param middle
     * @param end
     */
    private static void merge(Comparable[] arr, int start, int middle, int end) {

        //将数组拷贝到辅助数组中
        int assisIndex = start;//辅助数组起始位置
        int i = start;//第一个数组起始位置
        int j = middle + 1;//第二个数组起始位置

        while (i <= middle && j <= end) {
            //如果arr[i]<arr[j]，则拷贝arr[i],并后移i一位
            if (CommonTool.greater(arr[j], arr[i])) {
                assistance[assisIndex] = arr[i];
                i++;
            } else {
                //如果arr[j]<arr[i]，则拷贝arr[j],并后移j一位
                assistance[assisIndex] = arr[j];
                j++;
            }
            //将辅助数组位置后移一位
            assisIndex++;
        }
        //将剩余数据拷贝到辅助数组中
        for (; i <= middle; i++) {
            assistance[assisIndex] = arr[i];
            assisIndex++;
        }
        for (; j <= end; j++) {
            assistance[assisIndex] = arr[j];
            assisIndex++;
        }

        //将辅助数组的数据拷贝到原数组中
        for (int s = start; s <= end; s++) {
            arr[s] = assistance[s];
        }
    }
}
