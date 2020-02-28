package com.biggw.LeetCode;

public class 整数反转 {
    public static void main(String[] args) {
        Solution solution = new 整数反转().new Solution();
        int reverse = solution.reverse(-123);
        System.out.println(reverse);
    }


    class Solution {
        public int reverse(int x) {
            long tmp = 0;
            do {
                tmp = tmp*10+x%10;
            } while ((x=x/10)!=0);
            if (tmp> 2147483647 || tmp < -2147483648)
                return 0;
            return (int)tmp;
        }
    }
}
