package com.haha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. 划分字母区间
 * https://leetcode-cn.com/problems/partition-labels/description/
 */
public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();
        //特判
        if (S == null || S.length() == 0) {
            return result;
        }

        //第一次遍历字符串，记录每个字母出现的最后一次下标
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            indexMap.put(S.charAt(i), i);
        }

        //第二次遍历，用end表示遍历到的字母中的最远下标
        //到达最远下标时，即可记录下标+1,作为切割点
        int end = 0;
        int preEnd = 0;
        for (int i = 0; i < S.length(); i++) {
            end = indexMap.get(S.charAt(i)) > end ? indexMap.get(S.charAt(i)) : end;
            if (i == end) {
                result.add((i + 1) - preEnd);
                preEnd = end + 1;
                end++;
            }
        }

        return result;
    }
}
