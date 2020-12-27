package leetcode.review.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = node1.left = new TreeNode(5);
        TreeNode node3 = node1.right = new TreeNode(-3);
        TreeNode node4 = node2.left = new TreeNode(3);
        TreeNode node5 = node2.right = new TreeNode(2);
        TreeNode node6 = node4.left = new TreeNode(3);
        TreeNode node7 = node4.right = new TreeNode(-2);
        TreeNode node8 = node5.left = new TreeNode(1);
        TreeNode node9 = node3.right = new TreeNode(11);

        System.out.println(Solution.pathSum(node1, 8));
    }

    static class Solution {
        public static int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            return helper(root, 0, map, sum);
        }

        public static int helper(TreeNode root, int curSum, Map<Integer, Integer> map, int sum) {
            if(root == null) {
                return 0;
            }
            curSum += root.val;
            int res = map.getOrDefault(curSum - sum, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            res += helper(root.left, curSum, map, sum) + helper(root.right, curSum, map, sum);
            map.put(curSum, map.getOrDefault(curSum, 0) - 1);
            return res;
        }
    }

    static class MySolution {
        public static int pathSum(TreeNode root, int sum) {
            int cnt = 0;
            helper(root, sum, cnt);
            return cnt;
        }

        private static void helper(TreeNode node, int sum, int cnt) {

            if(sum < 0 || node == null) {
                return;
            }

            if(sum == 0) {
                cnt++;
                return;
            }
            while (node != null) {
                sum -= node.val;
                helper(node.left, sum, cnt);
                helper(node.right, sum, cnt);
            }
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
