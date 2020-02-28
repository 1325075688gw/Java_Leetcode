package com.biggw.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并K个链表 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
// 用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表，
// 然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空。
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val-o2.val;
                }
            });
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            for (ListNode list : lists) {
                if(list!=null){
                    queue.add(list);
                }
            }
            while (!queue.isEmpty()){
                ListNode temp = queue.poll();
                cur.next = temp;
                cur = cur.next;
                if (temp.next!=null) {
                    queue.add(temp.next);
                }
            }
            return dummy.next;

        }
    }
}
