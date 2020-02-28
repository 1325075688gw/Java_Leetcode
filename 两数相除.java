package com.biggw.LeetCode;

public class 两数相除 {
    public static void main(String[] args) {
        两数相除 obj = new 两数相除();
        Solution solution = obj.new Solution();
        int divide = solution.divide(-2147483648, -1);
        System.out.println(divide);
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            boolean sign = (dividend ^ divisor) < 0;
            int res = 0;
            long bcs = Math.abs((long)dividend);
            long cs = Math.abs(divisor);
            if (bcs == 0 || bcs < cs) {
                return 0;
            }

            while (bcs >= cs) {
                long temp_cs = cs;
                long temp_res = 1;
                while (bcs >= (temp_cs << 1)) {
                    temp_cs <<= 1;
                    temp_res <<= 1;
                }
                bcs = bcs - temp_cs;
                res += temp_res;
            }

            res = sign == false ? res : -res;
            if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (res < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else
                return res;
        }
    }
}
