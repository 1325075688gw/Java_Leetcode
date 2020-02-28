package com.biggw.LeetCode;

import java.util.HashMap;
import java.util.Set;

public class 罗马数字转整数13 {
    public static void main(String[] args) {
        罗马数字转整数13 obj = new 罗马数字转整数13();
        Solution solution = obj.new Solution();
        int i = solution.romanToInt("III");
        System.out.println(i);
    }

    class Solution {
        public int romanToInt(String s) {
            Character[] arr = {'M', 'D', 'C', 'L', 'X', 'V','I'};
            Integer[] values = {1000, 500, 100, 50, 10, 5, 1};

            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                hashMap.put(arr[i], values[i]);
            }

            int res = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                res = hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1)) ? res - hashMap.get(s.charAt(i)) : res + hashMap.get(s.charAt(i));
            }
            res += hashMap.get(s.charAt(s.length()-1));
            return res;
        }
    }
}
