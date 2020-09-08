package leetcode.medium;

import sun.nio.cs.ext.SJIS_0213;

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
            int[] count = new int[]{0,0};

            helper(root, 0, count);

            return Math.max(count[0], count[1]);
        }

        private static void helper(TreeNode root, int index, int[] count) {
            if(root == null) {
                return;
            }

            count[index%2] += root.val;
            helper(root.left, index+1, count);
            helper(root.right, index+1, count);
        }
    }

    class SolutionDFS {
        public int rob(TreeNode root) {
            if(root == null)
                return 0;

            int[] result = helper(root);
            return Math.max(result[0], result[1]);
        }

        private int[] helper(TreeNode node) {
            if(node == null) {
                return new int[]{0,0};
            }

            int[] left = helper(node.left);
            int[] right = helper(node.right);

            int rob = node.val + left[1] + right[1];
            int noRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return new int[]{rob, noRob};
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
