package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = node1.right = new TreeNode(2);
        TreeNode node3 = node2.left = new TreeNode(3);
        System.out.println(IterativeSolution.inorderTraversal(node1));
    }

    static class IterativeSolution {
        public static List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;

            while(!stack.isEmpty() || node != null) {

                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }

                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
            return result;
        }
    }

    static class RecusiveSolution {
        public static List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private static void helper(TreeNode node, List<Integer> result) {
            if(node == null) {
                return;
            }

            helper(node.left, result);
            result.add(node.val);
            helper(node.right, result);
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
