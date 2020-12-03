package com.haha.sort;

import com.haha.common.CommonTool;

import java.util.Arrays;

/**
 * 堆排序
 * 每次都将数组(二叉树)调整成大顶堆，取出堆顶，重复调整，获得升序排序的数组
 */
public class Heap {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, -1, 89, 44, 23, -99};
        heapSort(arr);
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {

        //将无序数组调整成大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 将堆顶元素与末尾元素交换，将最大元素沉到数组末端
        // 重新调整结构，使其满足堆定义，继续交换堆顶元素和当前最末元素，直到序列有序
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjustHeap(arr, 0, j);
        }

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 将一个数组，调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length是在不断减少的
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];// 先取出当前元素的值，保存在临时变量
        //开始调整
        // 1 k = i*2+1 k是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { //说明左子节点的值小于右子节点的值
                k++; // 指向右子节点
            }
            if (arr[k] > temp) { //如果子节点大于父节点
                arr[i] = arr[k]; //把较大的值，付给当前的节点
                i = k;//让i指向k,继续循环比较
            } else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的数的最大值，放在最顶端
        arr[i] = temp;// 将temp值放在调整后的位置
    }
}
