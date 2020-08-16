package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = node1.next =  new ListNode(2);
        ListNode node3 = node2.next = new ListNode(0);
        ListNode node4 = node3.next = new ListNode(-4);
        node4.next = node1;

        System.out.println(Solution.detectCycle(node1));
    }

    public static class Solution {
        public static ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null || fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) break;
            }
            if(fast == null || fast.next == null) return null;

            while (head != fast) {
                head = head.next;
                fast = fast.next;
            }

            return head;
        }
    }

    public static class SolutionWithSpace {
        public static ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();

            while (head != null) {
                if(set.contains(head))
                    return head;
                set.add(head);
                head = head.next;
            }
            return null;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
