package com.haha.leetcode;

/**
 * 744. 寻找比目标字母大的最小字母
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j');
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
}
