package com.biggw.LeetCode;

public class 回文数 {
    public static void main(String[] args) {
        回文数 obj = new 回文数();
        Solution solution = obj.new Solution();
        boolean palindrome = solution.isPalindrome2(11);
        System.out.println(palindrome);
    }

    class Solution {
        public boolean isPalindrome(int x) {
            if(x<0) return false;
            String s = String.valueOf(x);
            int len = s.length();
            int temp = 0;
            int count = 0;
            do{
                temp = x%10;
                x = x/10;
            }while (temp==(s.charAt(count)-'0') && ++count < len);

            return count==len?true:false;
        }

        public boolean isPalindrome2(int x) {
            if(x<0) return false;
            int bak = x;
            int temp = 0;
            do{
                temp = temp*10 + x%10;
                x = x/10;
            }while (x>0);

            return bak==temp?true:false;
        }
    }
}
