package com.biggw.LeetCode;

public class 接雨水 {
    public static void main(String[] args) {

    }

    class Solution {
        public int trap(int[] height) {
            int len = height.length;
            if (len <= 1) return 0;

            int res = 0;
            int highId = 0;
            int highNum = 0;
            for (int i = 0; i < len; i++) {
                if (height[i] > highNum) {
                    highId = i;
                    highNum = height[i];
                }
            }
            int leftHigh = height[0];
            // 从左边往最高点遍历
            for (int i = 0; i < highId; i++) {
                if (height[i] > leftHigh) {
                    leftHigh = height[i];
                } else {
                    res += leftHigh - height[i];
                }
            }

            int rightHigh = height[len - 1];
            // 从右边往最高点遍历
            for (int i = len - 1; i > highId; i--) {
                if (height[i] > rightHigh) {
                    rightHigh = height[i];
                } else {
                    res += rightHigh - height[i];
                }
            }
            return res;
        }

        public int trap2(int[] height) {
            int len = height.length;
            if (len <= 1) return 0;

            int res = 0;
            int[] left = new int[len];
            int[] right = new int[len];
            for (int i = 1; i < len; i++) {
                left[i] = Math.max(left[i-1],height[i-1]);
            }
            for (int i = len-1-1; i > 0; i--) {
                right[i] = Math.max(right[i+1],height[i+1]);
            }

            for (int i = 1; i < len-1; i++) {
                int temp = Math.min(right[i], left[i]);
                if (temp>height[i]){
                    res += temp-height[i];
                }
            }
            return res;
        }
    }
}
