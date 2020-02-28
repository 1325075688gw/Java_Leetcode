package com.biggw.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        三数之和 obj = new 三数之和();
        Solution solution = obj.new Solution();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = solution.threeSum(arr);
        System.out.println(list);
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>(new ArrayList<>());
            if (nums.length<=2) return list;

            int len = nums.length;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i]>0) break;
                if (i>0 && nums[i]==nums[i-1]) continue;
                int j = i+1;
                int k = len-1;
                while (j<k) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if (sum>0) k--;
                    else if (sum<0) j++;
                    else {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        arrayList.add(nums[i]);
                        arrayList.add(nums[j]);
                        arrayList.add(nums[k]);
                        list.add(arrayList);
                        while (j<k && nums[j]==nums[j+1])
                            j++;
                        while (j<k && nums[k]==nums[k-1])
                            k--;
                        j++;
                        k--;
                    }
                }
            }
            return  list;
        }
    }
}
