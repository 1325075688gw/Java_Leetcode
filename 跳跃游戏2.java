package com.biggw.LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

public class 跳跃游戏2 {
    public static void main(String[] args) {
        跳跃游戏2 obj = new 跳跃游戏2();
        Solution solution = obj.new Solution();
        int[] arr = new int[] {1,2};
        int jump = solution.jump(arr);
        System.out.println(jump);
    }
    class Solution {
        public int jump(int[] nums) {
            int len = nums.length;
            if (len<=1) return 0;

            int res = 0;
            int distance = nums[0];
            int temp = 0;
            for (int i = 0; i < len; i++) {
                distance = Math.max(nums[i]+i, distance);
                // 按照数组下标索引，判断跳出去没有
                if (distance>=len-1){
                    return ++res;
                }
                // 如果我们最后达到了上一次distance的点，说明我们只需走一步
                if (i == temp) {
                    res++;
                    temp = distance;
                }
            }
            return res;

        }
    }
}
