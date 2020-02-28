package com.biggw.LeetCode;

public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        删除排序数组中的重复项 obj = new 删除排序数组中的重复项();
        Solution solution = obj.new Solution();
        int[] arr = new int[]{1, 1, 2};
        int i = solution.removeDuplicates(arr);
        System.out.println(i);
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int j = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[j] != nums[i]) {
                    nums[++j] = nums[i];
                }
            }
            // j是索引，最后返回长度需要加1
            return ++j;
        }
    }
}
