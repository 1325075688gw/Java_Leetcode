package com.biggw.LeetCode;

import java.util.List;

public class 删除链表的倒数第N个节点 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode(0);
            ListNode fast = dummy;
            ListNode slow = dummy;
            dummy.next = head;
            while (n >=1) {
                if (fast.next == null) {
                    return null;
                }
                fast = fast.next;
                n--;
            }

            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
