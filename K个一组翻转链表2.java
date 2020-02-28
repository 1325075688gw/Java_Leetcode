package com.biggw.LeetCode;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Stack;

public class K个一组翻转链表2 {
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
        public void reverseKGroup(ListNode head, int k) {
            Stack<ListNode> stack = new Stack<ListNode>();
            ListNode dummy = new ListNode(0);
            ListNode cur = head;
            while (true) {
                int count = 0;

                while (count < k) {
                    count++;
                    stack.add(cur);
                    if (cur.next != null)
                        cur = cur.next;
                    else break;
                }
                if (count != k) {
//                    return head;
                }
                while (!stack.empty()) {
                    ListNode pop = stack.pop();
                    dummy.next = pop;
                    dummy = dummy.next;
                }
                dummy.next = cur;
                head = cur;

            }
//            return null;
        }
    }
}
