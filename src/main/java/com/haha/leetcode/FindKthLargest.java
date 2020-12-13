package com.haha.leetcode;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargest {


    //使用大顶堆
    public int findKthLargest(int[] nums, int k) {
        //使用大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int num : nums) {
            priorityQueue.offer(num);
        }

        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }

        // 返回第k个数据
        return priorityQueue.poll();
    }


    //使用小顶堆
    public int findKthLargest_2(int[] nums, int k) {
        //使用小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int num : nums) {
            priorityQueue.offer(num);
            //超过k时，去掉最小的数据
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        // 返回第k个数据
        return priorityQueue.poll();
    }

    public int findKthLargest_1(int[] nums, int k) {
        //构建大顶堆
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);

        //不断删除堆顶元素，调整堆，直到得到第k个元素
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            swap(nums, 0, i);
            heapSize--;
            //调整成大顶堆
            maxHeapify(nums, 0, heapSize);
        }

        //返回第0个元素
        return nums[0];
    }

    //构建大顶堆
    private void buildMaxHeap(int[] nums, int heapSize) {
        //从下往上调整，构建大顶堆
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    // 调整下标i下的元素位置，使之成为大顶堆
    private void maxHeapify(int[] arr, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        //找到左右子树与自身元素的最大值
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        //如果不是自身元素，则与该子树交换数据，并且调整该子树，使之成为大顶堆
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    //交换数组元素
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
