package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = node1.right = new TreeNode(2);
        TreeNode node3 = node2.left = new TreeNode(3);
        System.out.println(SolutionRecusive.inorderTraversal(node1));
    }
    
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
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

    static class SolutionRecusive {
        public static List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private static void helper(TreeNode node, List<Integer> result) {
//            if(node == null) return;
            if(node != null) {
                if (node.left != null) {
                    helper(node.left, result);
                }
                result.add(node.val);
                if (node.right != null) {
                    helper(node.right, result);
                }
            }
        }
    }

    class SolutionRecusiveBest {
        List<Integer> li = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root==null){
                return li;
            }
            inorderTraversal(root.left);
            li.add(root.val);
            inorderTraversal(root.right);
            return li;
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
