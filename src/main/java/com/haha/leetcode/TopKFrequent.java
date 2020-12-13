package com.haha.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(nums, k);
    }

    public int[] topKFrequent(int[] nums, int k) {
        //构建map,保存每个元素的重复次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.getOrDefault(nums[i], 0);
            count++;
            countMap.put(nums[i], count);
        }

        //构建小顶堆，将map中的数据放进去，如果到达k，去掉其他数据
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (priorityQueue.size() < k) {
                Integer[] item = new Integer[]{count, num};
                priorityQueue.offer(item);
            } else {
                Integer[] litterValue = priorityQueue.poll();
                if (litterValue[0] > count) {
                    priorityQueue.offer(litterValue);
                } else {
                    Integer[] item = new Integer[]{count, num};
                    priorityQueue.offer(item);
                }
            }
        }

        //将k大小的小顶堆数据取出，放到数组中，并返回
        int[] result = new int[k];
        int index = 0;
        while (priorityQueue.size() > 0) {
            Integer[] poll = priorityQueue.poll();
            result[index] = poll[1];
            index++;
        }

        return result;
    }
}
