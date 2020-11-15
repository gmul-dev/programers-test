package leetcode.review;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    int min = Integer.MIN_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min > x) min = x;
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

class MinStack1 {

    Node curr;

    /** initialize your data structure here. */
    public MinStack1() {

    }

    public void push(int x) {
        Node temp = new Node(x);
        temp.min = (curr == null) ? x : Math.min(x, curr.min);
        if(curr != null){
            temp.next = curr;
        }
        curr = temp;
    }

    public void pop() {
        if(curr != null){
            curr = curr.next;
        }
    }

    public int top() {
        if(curr != null){
            return curr.val;
        }else{
            return Integer.MIN_VALUE;
        }
    }

    public int getMin() {
        if(curr != null){
            return curr.min;
        }else{
            return Integer.MIN_VALUE;
        }
    }
}

class Node{
    int val;
    Node next;
    int min;

    public Node(int val){
        this.val = val;
    }
}
