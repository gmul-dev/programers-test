package leetcode.review.leetcode.medium;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(Solution.addTwoNumbers(l1,l2));
    }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }

    static class MySolution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null)
                return l2;
            if(l2 == null)
                return l1;

            ListNode dummy = new ListNode(0);
            ListNode node = dummy;
            int count = 0;
            while (l1 != null && l2 != null) {
                int sum = count + l1.val + l2.val;
                count = sum / 10;
                node.next = new ListNode(sum % 10);

                node = node.next;
                l1 = l1.next;
                l2 = l2.next;
            }

            while (l1 != null) {
                int sum = count + l1.val;
                count = sum / 10;
                node.next = new ListNode(sum % 10);

                node = node.next;
                l1 = l1.next;
            }

            while (l2 != null) {
                int sum = count + l2.val;
                count = sum / 10;
                node.next = new ListNode(sum % 10);

                node = node.next;
                l2 = l2.next;
            }

            if(count == 1) {
                node.next = new ListNode(count);
            }
            return dummy.next;
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
