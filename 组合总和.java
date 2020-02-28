package com.biggw.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args) {
        组合总和 obj = new 组合总和();
        Solution solution = obj.new Solution();
        int[] arr = {2,3,6,7};
        List<List<Integer>> list = solution.combinationSum(arr, 7);
        System.out.println(list);
    }

    class Solution {

        List<List<Integer>> lists = new ArrayList<>(new ArrayList<>());
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            help(candidates, 0, 0, target);
            return lists;
        }

        private void help(int[] candidates, int index, int temp, int target) {
            if (temp > target) {
                return;
            }
            if (temp == target) {
                System.out.println(arrayList);
                lists.add((ArrayList<Integer>) arrayList.clone());
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                arrayList.add(candidates[i]);
                help(candidates, i, temp+candidates[i],target);
                arrayList.remove(arrayList.size() - 1);
            }
        }

        private int sum(ArrayList arr) {
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum += (int) arr.get(i);
            }
            System.out.println(sum);
            return sum;
        }
    }

}
