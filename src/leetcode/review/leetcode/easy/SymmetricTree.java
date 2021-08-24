package leetcode.review.leetcode.easy;

import static leetcode.review.leetcode.easy.SymmetricTree.Solution.isSymmetric;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = node1.left = new TreeNode(2);
        TreeNode node3 = node1.right = new TreeNode(2);
        TreeNode node4 = node2.right = new TreeNode(3);
        TreeNode node5 = node3.right = new TreeNode(3);
        System.out.println(isSymmetric(node1));
    }

    static class Solution {
        public static boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        public static boolean isMirror(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            return (t1.val == t2.val)
                    && isMirror(t1.right, t2.left)
                    && isMirror(t1.left, t2.right);
        }
//        public static boolean isSymmetric(TreeNode root) {
//            if(root == null) return true;
//            if(root.left == null && root.right == null) return true;
//            return helper(root.left, root.right);
//        }
//
//        private static boolean helper(TreeNode right, TreeNode left) {
//            if(right == null && left == null) {
//                return true;
//            }
//            if(right == null || left == null) {
//                return false;
//            }
//            if(right.val != left.val) {
//                return false;
//            }
//            return helper(left.left, right.right) && helper(left.right, right.left);
//        }
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
