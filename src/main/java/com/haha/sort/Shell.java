package com.haha.sort;

import com.haha.common.CommonTool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 希尔排序
 * 选定一个增长量，按照增长量对数据分成"增长量"个数组
 * 对每一分组进行插入排序，然后再减少增长量
 */
public class Shell {

    public static void main(String[] args) throws Exception {

        Integer[] array = {4, 5, 7, 2, 76, 98, 23, 456, 1};
        System.out.println(Arrays.toString(array));
        Shell.sort(array);
        // 输出结果
        System.out.println(Arrays.toString(array));


        List<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Shell.class.getClassLoader().getResourceAsStream("reverse_arr.txt")));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            int i = Integer.parseInt(line);
            list.add(i);
        }
        bufferedReader.close();
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);

        //最坏情况测试
        //测试插入排序,10万条数据，使用时间 23146 ms
        Insert.sort(arr);
        //测试希尔排序，10万条数据，使用时间 25ms
//        Shell.sort(arr);
        //测试归并排序，10万条数据，使用时间 80ms
//       Merge.sort(arr);
    }


    public static void sort(Comparable[] arr) {
        int h = 0;
        while (h < arr.length / 2) {
            h = 2 * h + 1;
        }

        //排序小于1时，不再排序
        while (h >= 1) {
            //按增长量进行插入排序
            for (int i = h; i < arr.length; i++) {
                //将当前数据，通过不断交换，插入到前面的有序数组中
                for (int j = i; j >= h; j -= h) {
                    if (CommonTool.greater(arr[j - h], arr[j])) {
                        CommonTool.exchange(arr, j - h, j);
                    } else {
                        break;
                    }
                }
            }


            //增长量减半
            h /= 2;
        }
    }
}
