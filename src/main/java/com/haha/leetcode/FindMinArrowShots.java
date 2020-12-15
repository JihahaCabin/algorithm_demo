package com.haha.leetcode;


import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //根据气球的end进行从小到大排序
        Arrays.sort(points, (item1, item2) -> item1[1] - item2[1]);
        //从气球的end发射箭，如果箭在其他球大小内，则也爆炸
        int count = 1;//箭的支数
        int arrow = points[0][1];//箭的位置
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] <= arrow && points[i][1] >= arrow) {
                continue;
            } else {
                arrow = points[i][1];
                count++;
            }

        }
        return count;

    }
}
