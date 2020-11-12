package leetcode.review;

import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(Solution.mergeTwoLists(l1, l2));
    }

    static class Solution {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            if(l1.val < l2.val) {
                l1.next=mergeTwoLists(l1.next,l2);
                return l1;
            } else {
                l2.next=mergeTwoLists(l1,l2.next);
            }
            return l2;
        }
//
//        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//            if(l1 == null) return l2;
//            if(l2 == null) return l1;
//
//            ListNode head = new ListNode();
//            ListNode result = head;
//
//            while (l1 != null || l2 != null) {
//                if(l1 == null) {
//                    result.next = l2;
//                    l2 = l2.next;
//                } else if(l2 == null) {
//                    result.next = l1;
//                    l1 = l1.next;
//                } else if(l1.val >= l2.val) {
//                    result.next = l2;
//                    l2 = l2.next;
//                } else if(l1.val < l2.val) {
//                    result.next = l1;
//                    l1 = l1.next;
//                }
//
//                result = result.next;
//            }
//            return head.next;
//        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
