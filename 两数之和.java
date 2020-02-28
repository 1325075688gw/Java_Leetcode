package com.biggw.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class 两数之和 {

    public static void main(String[] args) {
        两数之和 obj = new 两数之和();
        int[] arr = new int[]{2,7,11,15};
        int[] ints = obj.twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target-nums[i];
            if (hashMap.containsKey(temp)){
                res[0] = hashMap.get(temp);
                res[1] = i;
                return res;
            }else {
                hashMap.put(nums[i], i);
            }
        }
        return res;
    }
}
