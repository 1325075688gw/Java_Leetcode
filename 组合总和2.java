package com.biggw.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和2 {
    public static void main(String[] args) {

    }

    class Solution {
        List<List<Integer>> lists = new ArrayList<>(new ArrayList<>());
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            help(candidates, 0, 0, target);
            return lists;
        }

        private void help(int[] candidates, int index, int temp, int target) {
            if (index > candidates.length || temp > target) {
                return;
            }
            if (temp == target) {
                lists.add((ArrayList<Integer>) arrayList.clone());
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                // 原数组[1，1，6],target = 7,因为数组排好序，所以相邻元素相等的话，必然会产生重复解【1，6】【1，6】
                // 递归回退后，i应该在index基础上加1，所以i不等于index，也就是开启新一轮回溯
                if (i != index && candidates[i] == candidates[i-1]) {
                    continue;
                }
                arrayList.add(candidates[i]);
                help(candidates, i+1, temp+candidates[i],target);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }
}
