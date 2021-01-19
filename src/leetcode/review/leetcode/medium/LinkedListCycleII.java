package leetcode.review.leetcode.medium;

public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = node1.next =  new ListNode(2);
        ListNode node3 = node2.next = new ListNode(0);
        ListNode node4 = node3.next = new ListNode(-4);
        node4.next = node2;

        System.out.println(Solution.detectCycle(node1));
    }

    public static class Solution {
        public static ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    slow = head;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return fast;
                }
            }

            return null;
        }
    }

    public static class MySolution {
        public static ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null)
                return null;

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
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
