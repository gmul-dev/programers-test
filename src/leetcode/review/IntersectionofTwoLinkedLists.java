package leetcode.review;

import leetcode.easy.IntersectionOfTwoLinkedLists;

public class IntersectionofTwoLinkedLists {

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(0);
        nodeA.next = new ListNode(9);
        nodeA.next.next = new ListNode(1);
        nodeA.next.next.next = new ListNode(2);
        nodeA.next.next.next.next = new ListNode(4);

        ListNode nodeB = new ListNode(3);
        nodeB.next = new ListNode(2);
        nodeB.next.next = new ListNode(4);

        System.out.println(Solution.getIntersectionNode(nodeA, nodeB));
    }

    public static class Solution {
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode a = headA;
            ListNode b = headB;
            while (a != b) {
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }
            return a;
        }
    }
    
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
