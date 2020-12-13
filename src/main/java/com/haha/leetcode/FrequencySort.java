package com.haha.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
 */
public class FrequencySort {

    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        frequencySort.frequencySort("tree");
    }

    public String frequencySort(String s) {
        //循环字符串中的字符，获取次数
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = countMap.getOrDefault(c, 0);
            count++;
            countMap.put(c, count);
        }

        //构建大顶堆，将元素依次放入
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((node1, node2) -> node2.count - node1.count);
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            priorityQueue.offer(node);
        }

        //将元素从大顶堆中取出
        char[] characters = new char[s.length()];
        int index = 0;
        while (priorityQueue.size() > 0) {
            Node poll = priorityQueue.poll();
            for (int i = 0; i < poll.count; i++) {
                characters[index] = poll.character;
                index++;
            }
        }

        //返回结果
        System.out.println(String.valueOf(characters));
        return String.valueOf(characters);
    }
}

class Node {
    Character character;
    int count;

    public Node(Character character, int count) {
        this.count = count;
        this.character = character;
    }
}
