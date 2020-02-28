package com.biggw.LeetCode;

import java.util.Arrays;

public class 字符串相乘 {
    public static void main(String[] args) {
        字符串相乘 obj = new 字符串相乘();
        Solution solution = obj.new Solution();
        String multiply = solution.multiply("22", "3");
        System.out.println(multiply);
    }

    class Solution {
        public String multiply(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();

            int[] res = new int[len1 + len2];
            for (int i = len1 - 1; i > -1; i--) {
                for (int j = len2 - 1; j > -1; j--) {
                    int temp = (chars1[i] - '0') * (chars2[j] - '0') + res[i + j + 1];
                    res[i + j + 1] = temp % 10;
                    res[i + j] += temp / 10;
                }
            }
            StringBuilder builder = new StringBuilder();
            int i;
            for (i = 0; i < len1 + len2; i++) {
                if (res[i] != 0) {
                    break;
                }
            }
            for (int j = i; j < len1+len2; j++) {
                builder.append(res[i]);
            }
            return builder.toString();
        }
    }
}
