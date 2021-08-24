package leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(Solution.mergeTwoLists(l1, l2));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null && l2 == null) return null;
            if(l1 == null || l2 == null) return (l1 != null)? l1 : l2;

            ListNode head = new ListNode();
            ListNode result = head;

            while (l1 != null && l2 != null) {
                if(l1.val > l2.val) {
                    head.next = new ListNode(l2.val);
                    head = head.next;
                    l2 = l2.next;
                } else {
                    head.next = new ListNode(l1.val);
                    head = head.next;
                    l1 = l1.next;
                }
            }

            if(l1 != null) head.next = l1;
            if(l2 != null) head.next = l2;

            return result.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}