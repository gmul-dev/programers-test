package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = node1.left = new TreeNode(2);
        TreeNode node3 = node1.right = new TreeNode(5);
        TreeNode node4 = node2.left = new TreeNode(3);
        TreeNode node5 = node2.right = new TreeNode(4);
        TreeNode node6 = node3.right = new TreeNode(6);
        SolutionIterator.flatten(node1);

    }

    static class Solution {
        public static void flatten(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            helper(root, q);

            root = q.poll();
            while (!q.isEmpty()) {
                root.right = q.poll();
                root.left = null;
                root = root.right;
            }
        }

        private static void helper(TreeNode node, Queue<TreeNode> q) {
            if(node == null) return;

            q.add(node);
            helper(node.left, q);
            helper(node.right, q);
        }
    }

//    class Solution {
//        public void flatten(TreeNode root) {
//            if (root == null) return;
//
//            Stack <TreeNode> stack = new Stack <TreeNode> ();
//            stack.push (root);
//            List <TreeNode> list = new ArrayList <TreeNode> ();
//
//            while (!stack.isEmpty()) {
//                TreeNode current = stack.pop();
//                if (current.right != null) stack.push (current.right);
//                if (current.left != null) stack.push (current.left);
//                list.add (current);
//            }
//
//            root = list.get(0);
//            for (int i = 1; i < list.size(); i++) {
//                root.right = list.get (i);
//                root.left = null;
//                root = list.get (i);
//            }
//        }
//    }

    static class SolutionIterator {
        public static void flatten(TreeNode root) {
            if(root == null)
                return;

            flatten(root.left);
            flatten(root.right);

            TreeNode right = root.right;
            TreeNode curr = root;

            root.right = root.left;
            root.left = null;

            while(curr.right != null) curr = curr.right;
            curr.right = right;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
