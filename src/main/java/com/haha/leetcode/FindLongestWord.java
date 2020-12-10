package com.haha.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/description/
 */
public class FindLongestWord {


    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        findLongestWord.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"));
    }

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String dest : d) {
            if (isSub(s, dest)) {
                //如果更长，则记录
                if (result.length() < dest.length()) {
                    result = dest;
                }
                //如果一样长，记录字典顺序更小的字符串
                if (result.length() == dest.length() && result.compareTo(dest) > 0) {
                    result = dest;
                }
            }
        }

        return result;

    }

    private boolean isSub(String s, String dest) {
        int si = 0;
        int desti = 0;
        //如果还未到结尾
        while (si < s.length() && desti < dest.length()) {
            //如果相同，则移动dest的指针
            if (s.charAt(si) == dest.charAt(desti)) {
                desti++;
            }
            si++;
        }

        if (desti == dest.length()) {
            return true;
        }
        return false;
    }
}
