package leetcode.review;

import leetcode.easy.DiameterOfBinaryTree;

public class DiameterofBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = node1.left = new TreeNode(2);
        TreeNode node3 = node1.right = new TreeNode(3);
        TreeNode node4 = node2.left = new TreeNode(4);
        TreeNode node5 = node2.right = new TreeNode(5);
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(node1));
    }
}

class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max;
    }

    private int diameter(TreeNode root) {
        if (root == null)
            return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
//        public static int diameterOfBinaryTree(TreeNode root) {
//            if(root == null) return 0;
//            if(root.left == null && root.right == null) return 0;
//
//            int right = helper(root.right);
//            int left = helper(root.left);
//
//            return right + left;
//        }
//
//        private static int helper(TreeNode node) {
//            if(node == null) return 0;
//            if(node.right == null && node.left == null) {
//                return 1;
//            }
//            int right = 1;
//            int left = 1;
//            if(node.right != null) {
//                right += helper(node.right);
//            }
//            if(node.left != null) {
//                left += helper(node.left);
//            }
//            return Math.max(right, left);
//        }
}

class TreeNode {
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