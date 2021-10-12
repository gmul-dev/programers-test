package leetcode;

import java.util.HashMap;

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

        PathSum s = new PathSum();
        System.out.println(s.pathSum(node1, 8));
    }

    int count = 0;
    int k;
    HashMap<Integer, Integer> h = new HashMap();

    public void preorder(TreeNode node, int currSum) {
        if (node == null)
            return;

        currSum += node.val;

        // 현재의 합이 target을 만족하는지 확인
        if (currSum == k)
            count++;

        // 현재까지의 부분합 중 target을 만족하는게 있는지 확인
        count += h.getOrDefault(currSum - k, 0);
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);

        preorder(node.left, currSum);
        preorder(node.right, currSum);

        h.put(currSum, h.get(currSum) - 1);
    }

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
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
