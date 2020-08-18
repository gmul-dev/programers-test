package leetcode.medium;

import java.util.List;

// Sort a linked list in O(n log n) time using constant space complexity.
public class SortList {

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        head = sortList(head);
        slow = sortList(slow);

        return mergeSort(head, slow);
    }

    private ListNode mergeSort(ListNode a, ListNode b){
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while(a != null && b != null) {
            if(a.val <= b.val) {
                pre.next = a;
                a = a.next;
            } else {
                pre.next = b;
                b = b.next;
            }
            pre = pre.next;
        }

        if(a != null) pre.next = a;
        if(b != null) pre.next = b;

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
