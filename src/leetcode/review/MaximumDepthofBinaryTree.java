package leetcode.review;

import leetcode.easy.MaximumDepthBinaryTree;

public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        System.out.println(Solution.maxDepth(new TreeNode(3, new TreeNode(9, null, null), new TreeNode( 20, new TreeNode(15, null, null), new TreeNode(17, null, null)))));
    }

    static class Solution {
        public static int maxDepth(TreeNode root) {
            return helper(root, 0);
        }

        private static int helper(TreeNode root, int depth) {
            if(root == null) return 0;

            int left = helper(root.left, depth);
            int right = helper(root.right, depth);

            return Math.max(left, right) + 1;
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
