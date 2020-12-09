package com.haha.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

/**
 * 双指针
 * 反转字符串中的元音字母
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 */
public class ReverseVowels {
    public String reverseVowels(String s) {

        if (s == null) {
            return null;
        }
        if ("".equals(s)) {
            return "";
        }

        char[] arrays = s.toCharArray();
        char[] result = new char[s.length()];

        //定义元音
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int i = 0;
        int j = arrays.length - 1;
        //为了兼容只有一个字符，所以要等号
        while (i <= j) {
            char ci = arrays[i];
            char cj = arrays[j];
            //判断是否i所在的字符为元音，不为则添加到返回集合中
            if (!characters.contains(ci)) {
                result[i] = ci;
                i++;
            }
            //判断是否j所在的字符为元音，不为则添加到返回集合中
            if (!characters.contains(cj)) {
                result[j] = cj;
                j--;
            }
            //如果i，j所在的字符为元音，则交换位置，添加到返回集合中
            if (characters.contains(ci) && characters.contains(cj)) {
                result[i] = cj;
                result[j] = ci;
                i++;
                j--;
            }
        }

        return new String(result);
    }
}
