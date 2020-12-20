package com.haha.search;

/**
 * 二分查找
 * 在递增数组中，查找数据
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 7);
        System.out.println(result);
    }

    public int binarySearch(int[] nums, int key) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            //为什么这么算，而不用(high+low)/2 ,因为在high+low时，有可能溢出int最大值
            int middle = low + (high - low) / 2;
            if (nums[middle] == key) {
                return middle;
            } else if (nums[middle] > key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;

    }
}
