package leetcode.review.leetcode.medium;

import java.util.Arrays;

public class SortList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = node1.next = new ListNode(2);
        ListNode node3 = node2.next = new ListNode(1);
        ListNode node4 = node3.next = new ListNode(3);

        System.out.println(Solution.sortList(node1));
    }

    static class Solution {
        public static ListNode sortList(ListNode head) {

            if (head == null){
                return null;
            }
            int length = 0;
            ListNode node = head;
            while (node != null){
                length ++;
                node = node.next;
            }

            ListNode globalHead = new ListNode(-1);
            globalHead.next = head;
            ListNode result = mergeSort(globalHead, 0, length -1);
            return result;
        }
        private static ListNode mergeSort(ListNode globalHead, int start, int end){
            if (start > end){
                return null;
            }
            else if (start == end){
                ListNode tmp = globalHead.next;
                globalHead.next = globalHead.next.next;
                tmp.next = null;
                return tmp;
            }
            else{
                //start > end
                int mid = (start + end ) /2;
                ListNode left = mergeSort(globalHead, start, mid);
                ListNode right = mergeSort(globalHead, mid + 1, end);
                return merge(left, right);
            }
        }
        private static ListNode merge(ListNode left, ListNode right){
            ListNode fakeHead = new ListNode(-1);
            ListNode now = fakeHead;
            while (left!=null && right !=null){
                if (left.val < right.val){
                    now.next = left;
                    now = now.next;
                    left = left.next;
                }
                else{
                    now.next = right;
                    now = now.next;
                    right = right.next;
                }//else
            }//while
            if (left !=null){
                now.next = left;
            }
            if (right !=null){
                now.next = right;
            }
            return fakeHead.next;
        }
    }

    static class MySolution {
        public static ListNode sortList(ListNode head) {

            int count = 0;
            ListNode curr = head;
            while (curr != null) {
                count++;
                curr = curr.next;
            }

            int[] items = new int[count];
            curr = head;
            for (int i = 0; i < count; i++) {
                items[i] = curr.val;
                curr = curr.next;
            }

            Arrays.sort(items);

            curr = head;
            for (int i = 0; i < items.length; i++) {
                curr.val = items[i];
                curr = curr.next;
            }

            return head;
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
