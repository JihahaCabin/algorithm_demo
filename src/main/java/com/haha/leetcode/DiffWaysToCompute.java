package com.haha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 * 递归计算，分而治之
 */
public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        //循环input,不断截取成左右两端，进行计算
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        result.add(getResult(l, r, c));
                    }
                }
            }
        }

        //如果没有数据，证明input为数字，直接存入
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }

        return result;
    }

    private Integer getResult(Integer left, Integer right, char c) {
        Integer result = null;
        switch (c) {
            case '+': {
                result = left + right;
                break;
            }
            case '-': {
                result = left - right;
                break;
            }
            case '*': {
                result = left * right;
                break;
            }
            default:
                break;
        }
        return result;
    }
}
