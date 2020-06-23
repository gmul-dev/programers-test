package leetcode;

import java.util.*;

public class MinStack {

//    List<Integer> stackList;
//
//    public MinStack() {
//        stackList = new ArrayList<>();
//    }
//
//    public void push(int x) {
//        stackList.add(x);
//    }
//
//    public void pop() {
//        stackList.remove(stackList.size()-1);
//    }
//
//    public int top() {
//        return stackList.get(stackList.size()-1);
//    }
//
//    public int getMin() {
//        int minValue = stackList.get(0);
//        for(Integer s tack : stackList) {
//            if(minValue > stack.intValue()) {
//                minValue = stack.intValue();
//            }
//        }
//        return minValue;
//    }


    /**
      * best time
     */

    Node node;

    public MinStack() {}

    public void push(int x) {
        if (node == null)
            node = new Node(x, x);
        else
            node = new Node(x, Math.min(node.min, x), node);
    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }

    private class Node {
        int val, min;
        Node next;
        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.testMinStack());
    }

    static class Solution {
        public static int testMinStack() {
            MinStack minStack = new MinStack();
            minStack.push(2);
            minStack.push(0);
            minStack.push(3);
            minStack.push(0);
            System.out.println(minStack.getMin());
            minStack.pop();
            System.out.println(minStack.getMin());
            minStack.pop();
            System.out.println(minStack.getMin());
            minStack.pop();
            System.out.println(minStack.getMin());

            return -1;
        }
    }
//  MinStack obj = new MinStack();
//  obj.push(x);
//  obj.pop();
//  int param_3 = obj.top();
//  int param_4 = obj.getMin();

}