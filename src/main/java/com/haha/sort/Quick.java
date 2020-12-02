package com.haha.sort;

import com.haha.common.CommonTool;

import java.util.Arrays;

/**
 * 快速排序
 * 找到一个基准值，将比基准值小的数，移动到左边，将比基准值大的数，移动到右边
 * 再将基准值左右两边的数据，继续进行快速排序、
 * 时间复杂度nLogN,最坏情况O(n^2)
 */
public class Quick {

    public static void main(String[] args) {
        Integer[] arr = {6, 7, 9, 3, 5, 2, 1};
        System.out.println(Arrays.toString(arr));
        Quick.sort(arr);
        // 输出结果
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        //找到一个基准值，将比基准值小的数，移动到左边，将比基准值大的数，移动到右边
        int partition = setPartition(arr, start, end);

        //对基准值左边的数组排序
        sort(arr, start, partition - 1);
        //对基准值右边的数组排序
        sort(arr, partition + 1, end);
    }

    /**
     * 找到一个基准值，将比基准值小的数，移动到左边，将比基准值大的数，移动到右边
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int setPartition(Comparable[] arr, int start, int end) {
        //将数组的start位置数据作为基准值
        int partition = start;
        int startIndex = start + 1;
        int endIndex = end;
        //如果两个位置不重合，要继续移动
        while (startIndex < endIndex) {
            //从右到左，找到一个比基准值小的数据
            while (CommonTool.greater(arr[endIndex], arr[partition]) && startIndex < endIndex) {
                endIndex--;
            }
            //从左到右，找到一个比基准值大的数据
            while (CommonTool.greater(arr[partition], arr[startIndex]) && startIndex < endIndex) {
                startIndex++;
            }

            //如果两个位置不重合，则交换两个位置的数据
            if (startIndex < endIndex) {
                CommonTool.exchange(arr, startIndex, endIndex);
            }
        }
        //如果两个位置重合了，证明已经将基准值左右数据移动好了
        //将基准值移动到中间
        CommonTool.exchange(arr, partition, endIndex);
        //返回基准值所在下标
        return endIndex;
    }
}
