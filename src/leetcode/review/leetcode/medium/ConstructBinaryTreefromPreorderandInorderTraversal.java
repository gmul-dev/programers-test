package leetcode.review.leetcode.medium;

import leetcode.medium.BinaryTreeLevelOrderTraversal;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    static class Solution {
        private int in = 0;
        private int pre = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, inorder, Integer.MIN_VALUE);
        }

        private TreeNode build(int[] preorder, int[] inorder, int stop) {

            if(pre >= preorder.length) {
                return null;
            }

            if(inorder[in] == stop) {
                in++;
                return null;
            }

            TreeNode node = new TreeNode(pre++);
            node.left = build(preorder, inorder, node.val);
            node.right = build(preorder, inorder, stop);

            return node;
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
