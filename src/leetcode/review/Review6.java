package leetcode.review;

//Remove Nth Node From End of List
public class Review6 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = node1.next = new ListNode(2);
        ListNode node3 = node2.next = new ListNode(3);
        ListNode node4 = node3.next = new ListNode(4);
        ListNode node5 = node4.next = new ListNode(5);

        System.out.println(Solution.removeNthFromEnd(node1, 2));
    }

    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            if(n == 0){
                return head;
            }
            ListNode next = head;
            ListNode currnt = head;
            ListNode pre = null;

            for (int i =0; i< n; i++){
                next = next.next;
            }
            while (next !=null){
                pre = currnt;
                currnt = currnt.next;
                next = next.next;
            }
            if(pre == null){
                return currnt.next;
            }else {
                pre.next = currnt.next;
                return head;
            }
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
