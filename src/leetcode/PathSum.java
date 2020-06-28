package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = node1.left = new TreeNode(5);
        TreeNode node3 = node1.right = new TreeNode(-3);
        TreeNode node4 = node2.left = new TreeNode(3);
        TreeNode node5 = node2.right = new TreeNode(2);
        TreeNode node6 = node3.right = new TreeNode(11);
        TreeNode node7 = node4.left = new TreeNode(3);
        TreeNode node8 = node4.right = new TreeNode(-2);
        TreeNode node9 = node5.left =new TreeNode(1);

        System.out.println(Solution.pathSum(node1, 8));
    }


    static class Solution {
        public static int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            return helper(root, 0, map, sum);

        }

        public static int helper(TreeNode root, int curSum, Map<Integer, Integer> map, int sum) {
            if (root == null) return 0;

            curSum += root.val;
            int res = map.getOrDefault(curSum - sum, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            res += helper(root.left, curSum, map, sum) + helper(root.right, curSum, map, sum);
            map.put(curSum, map.getOrDefault(curSum, 0) - 1);
            return res;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
