package com.biggw.LeetCode;

public class 最长有效括号 {
    public static void main(String[] args) {

    }

    class Solution {
        public int longestValidParentheses(String s) {
            int len = s.length();
            if (len<2) return 0;

            int[] dp = new int[len];
            int res = 0;
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == ')'){
                    int pre = i-dp[i-1]-1;
                    if (pre>=0 && s.charAt(pre)=='(') {
                        dp[i] = dp[i-1]+2;
                        if (pre>0) {
                            dp[i] = dp[i] +dp[pre-1];
                        }
                        if (dp[i]>res){
                            res = dp[i];
                        }
                    }
                }
            }
            return res;
        }
    }
}
