package leetcode.easy;

import java.util.List;

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


    static class Solution1 {
        public boolean isPalindrome(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;

            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = head;
            slow = reversed(slow);

            while(fast!=null && slow != null){

                if(fast.val != slow.val){
                    return false;
                }
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }

        public ListNode reversed(ListNode head){

            ListNode prev = null;
            ListNode next = null;

            while(head!=null){
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }

    static class Solution {
        public static boolean isPalindrome(ListNode head) {

            if(head==null || head.next==null) {
                return true;
            }
            ListNode slow = head;
            ListNode prev = null;
            ListNode fast = head;

            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                System.out.println("fast : " + fast.val);
                ListNode temp = slow.next;
                slow.next = prev;
                System.out.println("slow.next : " + ((slow.next != null)? slow.next.val : "null"));
                prev = slow;
                System.out.println("prev : " + prev.val);
                slow = temp;
                System.out.println("slow : " + slow.val);
            }

            ListNode forward;
            ListNode back ;

            if(fast.next == null) {
                forward = slow.next;
                back = prev;
            } else {
                forward = slow.next;
                slow.next = prev;
                back = slow;
            }

            while(forward.next != null && back.next != null && forward.val == back.val) {
                forward = forward.next;
                back = back.next;
            }

            if(forward.next == null && back.next == null && (forward.val == back.val)) {
                return true;
            }

            return false;

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
