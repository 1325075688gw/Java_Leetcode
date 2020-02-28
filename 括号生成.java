package com.biggw.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args) {
        括号生成 obj = new 括号生成();
        Solution solution = obj.new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

    class Solution {
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        public List<String> generateParenthesis(int n) {
            help(0, 0, n);
            return list;
        }

        public void help(int index1, int index2, int n) {
            if (index1 > n || index2 > n || index1 < index2) {
                return;
            }

            if (index1 == n && index2 == n) {
                list.add(temp.toString());
                return;
            }
            temp.append("(");
            help(index1 + 1, index2, n);
            temp.replace(temp.length() - 1, temp.length(), "");
            temp.append(")");
            help(index1, index2 + 1, n);
            temp.replace(temp.length() - 1, temp.length(), "");

        }
    }
}
