package com.haha.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        heapSort(new int[]{1, 4, 23, 2, 5, 7, 43, 2});
    }


    private static void heapSort(int[] arr) {
        //建立初始大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAjust(arr, i, arr.length);
        }

        //不断将最大值，放到最后一位，再重新构建大顶堆
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapAjust(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr    数组
     * @param i      开始调整的位置
     * @param length 需要调整的长度
     */
    private static void heapAjust(int[] arr, int i, int length) {


        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //比较左右节点，获取最大值的节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //交换值
            if (arr[i] < arr[k]) {
                int temp = arr[i];//临时记录
                arr[i] = arr[k];
                arr[k] = temp;
                i = k;
            } else {
                break;
            }

        }


    }
}
