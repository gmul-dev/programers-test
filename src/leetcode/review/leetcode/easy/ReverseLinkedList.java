package leetcode.review.leetcode.easy;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = node1.next = new ListNode(2);
        ListNode node3 = node2.next = new ListNode(3);
        ListNode node4 = node3.next = new ListNode(4);
        ListNode node5 = node4.next = new ListNode(5);

        System.out.println(SolutionIterative.reverseList(node1));
    }

    static class SolutionRecusive {
        public static ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }

//        public ListNode reverseList(ListNode head) {
//            return reverseRecursive(head, null);
//        }
//
//        private ListNode reverseRecursive(ListNode curr, ListNode prev) {
//            if (curr == null) {return prev;}
//            ListNode next = curr.next;
//            curr.next = prev;
//            return reverseRecursive(next, curr);
//        }
    }

    static class SolutionIterative {
        public static ListNode reverseList(ListNode head) {

            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return curr;
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
