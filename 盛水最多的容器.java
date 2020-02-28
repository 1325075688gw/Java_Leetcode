package com.biggw.LeetCode;

public class 盛水最多的容器 {
    public static void main(String[] args) {
        Solution solution = new 盛水最多的容器().new Solution();
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = solution.maxArea(arr);
        System.out.println(maxArea);
    }


    class Solution {
        public int maxArea(int[] height) {
            int len = height.length;
            if (len == 0) return 0;

            int left = 0;
            int right = len - 1;
            int maxArea = 0;

            while (left < right) {
                int width = right - left;
                int heigh = Math.min(height[left], height[right]);
                maxArea = Math.max(maxArea, heigh*width);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
    }

}
