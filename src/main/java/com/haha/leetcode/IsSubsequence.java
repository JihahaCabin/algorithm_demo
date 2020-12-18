package com.haha.leetcode;

/**
 * 392. 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/description/
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        //循环主序列
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            if (j < s.length()) {
                char sj = s.charAt(j);
                if (sj == tc) {
                    j++;
                }
            }
        }

        return j == s.length();
    }
}
