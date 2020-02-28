package com.biggw.LeetCode;

public class 整数转罗马数字12 {

    public static void main(String[] args) {
        整数转罗马数字12 obj = new 整数转罗马数字12();
        Solution solution = obj.new Solution();
        String s = solution.intToRoman(450);
        System.out.println(s);
    }

    class Solution {
        public String intToRoman(int num) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] arr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                while (num >= values[i]) {
                    num -= values[i];
                    res.append(arr[i]);
                }
            }
            return res.toString();
        }
    }

}