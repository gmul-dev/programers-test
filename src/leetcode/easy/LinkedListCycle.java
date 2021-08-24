package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {

        ListNode nodeA = new ListNode(3);
        ListNode nodeB = nodeA.next = new ListNode(0);
        ListNode nodeC = nodeB.next = new ListNode(2);
        ListNode nodeD = nodeC.next = new ListNode(-4);
        nodeD.next = nodeA;

        System.out.println(SolutionBest.hasCycle(nodeA));
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

    static class Solution {
        public static boolean hasCycle(ListNode head) {
            ListNode current = head;
            Set<ListNode> nodeList = new HashSet<>();
            while (current != null) {
                if(!nodeList.contains(current)) {
                    nodeList.add(current);
                    current = current.next;
                }else{
                    return true;
                }
            }
            return false;
        }
    }

    static class SolutionBest {
        public static boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode p1 = head;
            ListNode p2 = head.next;
            while (p2 != null && p2.next != null) {
                if (p1 == p2) {
                    return true;
                }
                p1 = p1.next;
                p2 = p2.next.next;
            }
            return false;
        }
    }
}