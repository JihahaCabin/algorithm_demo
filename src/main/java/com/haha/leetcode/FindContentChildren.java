package com.haha.leetcode;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class FindContentChildren {

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        FindContentChildren findContentChildren = new FindContentChildren();
        findContentChildren.findContentChildren(g, s);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            for (; j < s.length; j++) {
                //如果满足孩子的胃口,则记录+1，判断下一个孩子是否满足
                if (g[i] <= s[j]) {
                    j++;
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
