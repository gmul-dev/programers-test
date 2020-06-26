package leetcode;

import java.util.*;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(7,node2, node1);
        TreeNode node6 = new TreeNode(2,node4, node3);
        TreeNode node7 = new TreeNode(4,node6, node5);
        System.out.println(Solution.invertTree(node7));
    }

    static class Solution {
        public static TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode right = invertTree(root.right);
            TreeNode left = invertTree(root.left);
            root.left = right;
            root.right = left;
            return root;
        }
    }

    static class SolutionIterator {
        public static TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            return root;
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
