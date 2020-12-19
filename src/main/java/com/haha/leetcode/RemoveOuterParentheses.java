package com.haha.leetcode;

public class RemoveOuterParentheses {

    public static void main(String[] args) {
        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        removeOuterParentheses.removeOuterParentheses("(()())(())");
    }

    public String removeOuterParentheses(String S) {
        String result = "";
        //特判
        if (S.length() == 0) {
            return result;
        }

        String temp = "";
        int count = 0; //用于记录总数
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            temp += S.charAt(i);

            //如果count =0;证明刚好一组，删除首位字符，添加到结果集
            if (count == 0) {
                temp = temp.substring(1);
                temp = temp.substring(0, temp.length() - 1);
                result += temp;
                temp = "";
            }

        }

        return result;
    }
}
