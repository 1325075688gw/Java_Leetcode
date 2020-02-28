package com.biggw.LeetCode;

import java.util.HashMap;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        无重复字符的最长子串 obj = new 无重复字符的最长子串();
        int length = obj.lengthOfLongestSubstring("abba");
        System.out.println(length);

    }

    // abba
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int res = 0;
        int start = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            boolean b = hashMap.containsKey(s.charAt(i));
            if (b && start < hashMap.get(s.charAt(i))+1){
                start = hashMap.get(s.charAt(i))+1;
            }
            hashMap.put(s.charAt(i),i);
            res = Math.max(res, i-start+1);
        }
        return res;
    }
}
