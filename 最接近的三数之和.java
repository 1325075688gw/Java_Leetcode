package com.biggw.LeetCode;

import java.util.Arrays;

public class 最接近的三数之和 {
    public static void main(String[] args) {
        最接近的三数之和 obj = new 最接近的三数之和();
        Solution solution = obj.new Solution();
        int[] arr = {-3,-2,-5,3,-4};
        int i = solution.threeSumClosest(arr, -1);
        System.out.println(i);
    }

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int len = nums.length;
            Arrays.sort(nums);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < len - 2; i++) {
                int j = i + 1;
                int k = len - 1;
                while (j < k) {
                    int temp = nums[i] + nums[j] + nums[k];
                    // 这儿必须要long，否则当target为负数时候会溢出
                    // [-3,-2,-5,3,-4],target = -1
                    if (Math.abs(temp - target) < Math.abs((long) res-target)) {
                        res = temp;
                    }
                    if (temp > target)
                        k--;
                    else if (temp < target) j++;
                    else return target;
                }

            }
            return res;
        }
    }

}
