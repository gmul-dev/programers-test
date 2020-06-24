package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoLinkedLists {

    //[0,9,1,2,4], listB = [3,2,4]
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
            int sizeA = 0;
            int sizeB = 0;
            ListNode tempHeadA = headA;
            ListNode tempHeadB = headB;
            while (tempHeadA != null) {
                sizeA++;
                tempHeadA = tempHeadA.next;
            }
            while (tempHeadB != null) {
                sizeB++;
                tempHeadB = tempHeadB.next;
            }
            int diff = Math.abs(sizeA - sizeB);
            ListNode biggerList;
            ListNode smallerList;
            if (sizeA > sizeB) {
                biggerList = headA;
                smallerList = headB;
            } else {
                biggerList = headB;
                smallerList = headA;
            }
            for (int i = 0; i < diff; i++) {
                biggerList = biggerList.next;
            }
            while (biggerList != null && smallerList != null) {
                if (biggerList == smallerList) {
                    return biggerList;
                }
                biggerList = biggerList.next;
                smallerList = smallerList.next;
            }
            return null;
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
