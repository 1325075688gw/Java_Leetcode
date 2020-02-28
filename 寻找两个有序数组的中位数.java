package com.biggw.LeetCode;

import java.util.Arrays;

public class 寻找两个有序数组的中位数 {
    public static void main(String[] args) {

        寻找两个有序数组的中位数 obj = new 寻找两个有序数组的中位数();

    }



// 思路：一个有序数组的长度为k，中位数可以这样表示。则中位数索引:((k+1)/2+(k+2)/2)/2 奇偶数通用
// 现在，我们有两个有序数组，一个数组为nums1，长度为n1；另一个数组为nums2，长度为n2.两个数组如果合并为一个有序数组后，长度为（n1+n2），则该有序数组的中位数索引为((（n1+n2）+1)/2+(（n1+n2）+2)/2)/2
// 现在我们知道了如果我们将两个有序数组合并为新的有序数组后，因为中位数的索引我们知道了，而且合并的新数组又是有序的。所以我们求中位数，就是等于求新合并的有序数组的第((（n1+n2）+1)/2+(（n1+n2）+2)/2)/2 个元素
// ，对不对。你品，你细品！
// 求 ((（n1+n2）+1)/2+(（n1+n2）+2)/2)/2 个元素
//  于是我们调用：return (func(nums1,nums2,left)+func(nums1,nums2,right))/2;

// public double func(int[] nums1, int[] nums2, int k) 函数的作用就是，求合并数组（虚拟合并）的第k个元素。
// 思路可以总结如下：取两个数组中的第k/2个元素进行比较，如果数组1的元素小于数组2的元素，则说明数组1中的前k/2个元素不可能成为第k个元素的候选，
// 所以将数组1中的前k/2个元素去掉，组成新数组和数组2求第k-k/2小的元素，因为我们把前k/2个元素去掉了，所以相应的k值也应该减小。另外就是注意处理一些边界条件问题，
// 比如某一个数组可能为空或者k为1的情况。

    public double findMedianSortedArrays(int[] nums1, int[] nums2, int k) {


        int len1 = nums1.length;
        int len2 = nums2.length;

        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (func(nums1,nums2,left)+func(nums1,nums2,right))/2;
    }


    public double func(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 == 0) return nums2[k - 1];
        if (len2 == 0) return nums1[k - 1];
        if (k==1) return Math.min(nums1[0],nums2[0]);

        int i = Math.min(len1, k / 2) - 1;
        int j = Math.min(len2, k / 2) - 1;

        if (nums1[i] < nums2[j]) {
            return func(Arrays.copyOfRange(nums1, i + 1, nums1.length), nums2, k - i - 1);
        } else {
            return func(nums1, Arrays.copyOfRange(nums2, j + 1, nums2.length), k - j - 1);
        }
    }
}
