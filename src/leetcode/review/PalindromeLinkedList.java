package leetcode.review;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = node1.next = new ListNode(2);
        ListNode node3 = node2.next = new ListNode(3);
        ListNode node4 = node3.next = new ListNode(3);
        ListNode node5 = node4.next = new ListNode(2);
        ListNode node6 = node5.next = new ListNode(1);
        System.out.println(Solution.isPalindrome(node1));
    }

    static class Solution {

        public static boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;
            int count = 0;
            while(fast.next != null) {
                fast = fast.next;
                count++;
                if (fast.next != null) {
                    fast = fast.next;
                    count++;
                }
                ListNode tmp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = tmp;
            }
            count++;
            if (count % 2 == 1) {
                slow = slow.next;
            }

            while(prev != null && slow != null) {
                if (prev.val != slow.val) return false;
                prev = prev.next;
                slow = slow.next;
            }

            return true;

        }

//        public static boolean isPalindrome(ListNode head) {
//            int count = 0;
//            ListNode node = head;
//            while(node != null) {
//                node = node.next;
//                count++;
//            }
//
//            int half = (int) Math.ceil(count/2);
//            node = head;
//            while (half > 0) {
//                node = node.next;
//                half--;
//            }
//
//            while (node != null) {
//                if(node.val != head.val) {
//                    return false;
//                }
//                node = node.next;
//                head = head.next;
//            }
//
//            return true;
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
