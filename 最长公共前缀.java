package com.biggw.LeetCode;

import java.util.HashSet;

public class 最长公共前缀 {

    public static void main(String[] args) {
        最长公共前缀 obj = new 最长公共前缀();
        Solution solution = obj.new Solution();
        String[] strs = {"ab", "a"};
        String s = solution.longestCommonPrefix2(strs);
        System.out.println(s);
        System.out.println("advb".indexOf("advbs"));
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            String reg = strs[0];
            for (String str : strs) {
                while (!str.startsWith(reg)) {
                    if (reg.length() == 1) {
                        return "";
                    }
                    reg = reg.substring(0, reg.length() - 1);
                }
            }
            return reg;
        }

        public String longestCommonPrefix2(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            HashSet<Character> hashSet = new HashSet<>();

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 0; j < strs.length; j++) {
                    try {
                        hashSet.add(strs[j].charAt(i));
                    } catch (Exception e) {
                        return res.toString();
                    }
                }
                int len = hashSet.size();
                if (len == 1) {
                    res.append(strs[0].charAt(i));
                    hashSet.clear();
                } else break;
            }
            return res.toString();
        }
    }
}
