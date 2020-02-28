package com.biggw.LeetCode;

public class 两数相加 {
    public static void main(String[] args) {

    }


      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        while (l1 != null || l2 != null || temp != 0){
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val+l2Val+temp;
            temp = sumVal/10;
            ListNode sumNode = new ListNode(sumVal%10);
            cursor.next = sumNode;
            cursor = cursor.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }
}
