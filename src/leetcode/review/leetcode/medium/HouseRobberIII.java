package leetcode.review.leetcode.medium;

public class HouseRobberIII {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = node1.left = new TreeNode(1);
        TreeNode node3 = node2.left = new TreeNode(2);
        TreeNode node4 = node3.left = new TreeNode(3);

        System.out.println(Solution.rob(node1));
    }

    static class Solution {

        public static int rob(TreeNode root) {
            int[] res = helper(root);
            return Math.max(res[0], res[1]);
        }
        
        private static int[] helper(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = helper(root.left);
            int[] right = helper(root.right);

            int rob = root.val + left[1] + right[1];
            int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return new int[]{rob, notRob};
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
