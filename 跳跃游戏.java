package com.biggw.LeetCode;

public class 跳跃游戏 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            if (len <= 1) return true;

            int distance = nums[0];
            for (int i = 0; i < len; i++) {
                if (distance < i) {
                    return false;
                }
                distance = Math.max(distance, nums[i]+i);
            }
            return true;
        }
    }
}
