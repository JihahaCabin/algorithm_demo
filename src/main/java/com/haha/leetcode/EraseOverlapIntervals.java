package com.haha.leetcode;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/description/
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        //特判
        if (intervals.length == 0) {
            return 0;
        }

        //根据起点从小到大排序
        Arrays.sort(intervals, (item1, item2) -> item1[0] - item2[0]);

        int end = intervals[0][1]; //当前的结束点
        int count = 1;//无重叠区间的数量

        for (int i = 1; i < intervals.length; i++) {
            //如果下一个区间起点小于当前区间的终点
            if (intervals[i][0] < end) {

                //如果下一个区间的终点也小于当前区间的终点,更新结束点为下一个区间的终点
                if (intervals[i][1] < end) {
                    end = intervals[i][1];
                }
                //如果下一个区间的终点大于当前区间的终点，则放弃该区间

            } else {
                //如果下一个区间起点大于当前区间的终点，没有重叠，则增加无重叠区间的数量，更新结束点
                count++;
                end = intervals[i][1];
            }
        }
        //返回需要移除的区间数量
        return intervals.length - count;
    }
}
