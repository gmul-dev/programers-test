package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

    public static void main(String[] args) {

    }

    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null) return null;

            Map<Node, Node> nodeMap = new HashMap<>();
            Node curr = new Node(0);

            while (head != null) {
                curr.next = head;
                if(nodeMap.containsKey(head)) {
                    curr.next = nodeMap.get(head);
                } else {
                    Node newNode = new Node(head.val, head.next, head.random);
                    nodeMap.put(head, newNode);
                    curr.next = newNode;
                }

                if(nodeMap.containsKey(head.random)) {
                    curr.random = nodeMap.get(head.random);
                } else if(head.random != null) {
                    Node newRandomNode = new Node(head.random.val, head.random.next, head.random.random);
                    nodeMap.put(head.random, newRandomNode);
                    curr.next.random = newRandomNode;
                }
                head = head.next;
                curr = curr.next;
            }
            return curr.next;
        }
    }

    class SolutionSpaceComplexN {
        public Node copyRandomList(Node head) {
            Map<Node,Node> map = new HashMap<>();
            Node node = head;
            while(node!=null){
                map.put(node, new Node(node.val));
                node = node.next;
            }
            node = head;
            while(node!=null){
                map.get(node).next = map.get(node.next);
                map.get(node).random = map.get(node.random);
                node = node.next;
            }
            return map.get(head);
        }
    }

    class Solution1 {
        public Node copyRandomList(Node head) {
            Node cur = head;
            while(cur != null) {
                Node next = cur.next;
                Node copy = new Node(cur.val);
                cur.next = copy;
                copy.next = next;
                cur = next;
            }

            cur = head;
            while(cur != null) {
                if(cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }

            Node dummy = new Node(0);
            Node iter = dummy;
            cur = head;
            while(cur != null) {
                Node next = cur.next.next;
                iter.next = cur.next;
                iter = iter.next;
                cur.next = next;
                cur = next;
            }
            return dummy.next;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
}
