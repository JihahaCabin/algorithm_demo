package com.haha.leetcode;

/**
 * 680. 验证回文字符串 Ⅱ
 * https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "abca";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.validPalindrome(s);
    }

    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        //加上等于，处理奇数个字符的情况
        while (i <= j) {
            //如果相等,则i前进，j后退
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                //如果不等，则尝试删除左边，或者右边的一个字符，用于比较是否相等
                return testPalidrome(s, i + 1, j) || testPalidrome(s, i, j - 1);
            }
        }
        return true;

    }

    //判断剩下的部分是否为回文
    private boolean testPalidrome(String s, int i, int j) {

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;

    }
}
