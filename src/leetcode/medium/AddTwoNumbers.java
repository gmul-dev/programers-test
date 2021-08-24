package leetcode.medium;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(Solution.addTwoNumbers(l1,l2));
    }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            if(l1.next != null || l2.next != null)
               result.next = addTwoNumbers(l1.next, l2.next);

            if(l1 == null) {
                result.val = l2.val;
                return result;
            } else if(l2 == null) {
                result.val = l1.val;
                return result;
            }

            result.val = l1.val + l2.val;
            if(result.val >= 10) {
                result.val %= 10;
                if(result.next == null) {
                    result.next = new ListNode(1);
                } else {
                    result.next.val += 1;
                }
            }
            return result;
        }
    }

    static class Solution1 {
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

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
