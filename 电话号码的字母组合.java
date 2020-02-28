package com.biggw.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        电话号码的字母组合 obj = new 电话号码的字母组合();
        Solution solution = obj.new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);
    }

    class Solution {
        List<String> list = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        Map<String, String> digitsMap = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return list;
            help(digits, 0);
            return list;
        }

        public void help(String digits, int index) {
            if (index >= digits.length()) {
                list.add(tmp.toString());
                return;
            }
            String s = digitsMap.get(String.valueOf(digits.charAt(index)));
            for (int i = 0; i < s.length(); i++) {
                tmp.append(s.charAt(i));
                help(digits, index+1);
                tmp.replace(tmp.length() - 1, tmp.length(), "");
            }
        }
    }
}
