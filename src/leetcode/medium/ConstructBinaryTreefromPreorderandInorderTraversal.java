package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {

    }

    class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, inorder, 0, inorder.length - 1, 0);
        }

        private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, int index) {
            if(start > end) return null;
            TreeNode root = new TreeNode(preorder[index]);

            int inIndex = start;
            while(preorder[index] != inorder[inIndex]) inIndex++;

            root.left = buildTree(preorder, inorder, start, inIndex - 1, index + 1);
            root.right = buildTree(preorder, inorder, inIndex + 1, end, index + inIndex - start + 1);

            return root;
        }
    }

    class SolutionBest {
        /*
           record leftSuccessor
           build binary tree with preorder
           3,9,20,15,7
               i
           9,3,15,20,7
           j

           when current leftSuccessor == inorder[j], means we finish leftSuccessor's left subtree, return


       */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, new int[1], inorder, new int[1], Integer.MAX_VALUE);
        }

        private TreeNode buildTree(int[] preorder, int[] preIdx, int[] inorder, int[] inIdx, int leftSuccessor) {
            if (inIdx[0] == inorder.length || inorder[inIdx[0]] == leftSuccessor) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preIdx[0]++]);
            root.left = buildTree(preorder, preIdx, inorder, inIdx, root.val);
            inIdx[0]++;
            root.right = buildTree(preorder, preIdx, inorder, inIdx, leftSuccessor);
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
