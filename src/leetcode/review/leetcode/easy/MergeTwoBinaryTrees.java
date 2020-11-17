package leetcode.review.leetcode.easy;

public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode firstNode1 = new TreeNode(1);
        TreeNode firstNode2 = firstNode1.left = new TreeNode(3);
        TreeNode firstNode3 = firstNode1.right = new TreeNode(2);
        TreeNode firstNode4 = firstNode2.left = new TreeNode(5);

        TreeNode secondNode1 = new TreeNode(2);
        TreeNode secondNode2 = secondNode1.left = new TreeNode(1);
        TreeNode secondNode3 = secondNode1.right = new TreeNode(3);
        TreeNode secondNode4 = secondNode2.right = new TreeNode(4);
        TreeNode secondNode5 = secondNode3.right = new TreeNode(7);

        System.out.println(Solution.mergeTrees(firstNode1, secondNode1));
    }
 
    static class Solution {
        public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

            TreeNode node = null;
            if(t1 == null) {
                return t2;
            } else if (t2 == null) {
                return t1;
            }

            node.val = t1.val + t2.val;
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);

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
