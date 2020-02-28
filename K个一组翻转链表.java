package com.biggw.LeetCode;

public class K个一组翻转链表 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // int count = k;
            ListNode cur = head;
            ListNode pre = null;
            ListNode next = null;
            ListNode check = head;
            // 检查能不能翻转
            int canProceed = 0;
            int count = 0;
            // 检查链表长度是否满足翻转
            while (canProceed < k) {
                if (check.next != null)
                    check = check.next;
                else
                    break;
                canProceed++;
            }
            // 满足条件，进行翻转
            if (k == canProceed) {
                while (count < k) {
                    next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                    count++;
                }
                if (next != null) {
                    // head 为链表翻转后的尾节点
                    head.next = reverseKGroup(next, k);
                }
                // prev 为链表翻转后的头结点
                return pre;
            } else
                // 不满住翻转条件，直接返回 head 即可
                return head;
        }
    }
}
