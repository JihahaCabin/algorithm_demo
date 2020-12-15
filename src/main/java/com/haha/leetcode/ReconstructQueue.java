package com.haha.leetcode;

import java.util.*;

/**
 * 406. 根据身高重建队列
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/description/
 */
public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        ReconstructQueue reconstructQueue = new ReconstructQueue();
        reconstructQueue.reconstructQueue(people);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            //如果身高相同，身高大于或等于h的人数少的在前
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            //如果身高不同，身高高的在前面
            return o2[0] - o1[0];
        });

        LinkedList<int[]> result = new LinkedList<>();

        //以身高大于或等于h的人数作为index,插入到结果集中
        // 如果人数相同，身高低的要在身高高的前面，不然不合规
        // 所以先插入高个子的，用add(index,element)，让矮个子的替换到高个子前面
        for (int[] p : people) {
            result.add(p[1], p);
        }
        return result.toArray(new int[people.length][2]);
    }

    public int[][] reconstructQueue_1(int[][] people) {

        List<int[]> result = new ArrayList<>();

        //先根据身高分组
        Map<Integer, List<int[]>> peopleMap = new HashMap<>();
        List<Integer> heightList = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int height = people[i][0];
            List<int[]> list = peopleMap.getOrDefault(height, new ArrayList<>());
            list.add(people[i]);
            peopleMap.put(height, list);
            if (!heightList.contains(height)) {
                heightList.add(height);
            }

        }
        //从大到小排序
        heightList.sort((item1, item2) -> item2 - item1);
        for (int i = 0; i < heightList.size(); i++) {
            //对每个分组中的人，根据比他高的人数进行从到大排序
            List<int[]> list = peopleMap.get(heightList.get(i));
            list.sort((item1, item2) -> item1[1] - item2[1]);
            //循环分组
            //如果是最高的分组，则直接添加到结果集
            if (i == 0) {
                result.addAll(list);
            } else {
                //如果不是最高的分组，则进行插入，插入位置为比他高的人数
                for (int j = 0; j < list.size(); j++) {
                    int[] thisPeople = list.get(j);
                    result.add(thisPeople[1], thisPeople);
                }
            }

        }
        return result.toArray(new int[people.length][2]);

    }
}
