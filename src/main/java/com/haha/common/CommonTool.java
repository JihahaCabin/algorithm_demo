package com.haha.common;

public class CommonTool {

    //比较C1是否大于C2
    public static boolean greater(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        return result > 0;
    }

    //交换下标i和j的元素
    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
