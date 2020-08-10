package leetcode.medium;

import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = node1.left = new TreeNode(9);
        TreeNode node3 = node1.right = new TreeNode(20);
        TreeNode node4 = node3.left = new TreeNode(15);
        TreeNode node5 = node3.right = new TreeNode(7);

        System.out.println(Solution.zigzagLevelOrder(node1));
    }

    static class Solution {
        public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root == null) return new ArrayList<>();

            List<List<Integer>> result = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean reverseLevel = false;
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                List<Integer> nodeList = new ArrayList<>();

                for(int i = 0; i < cnt; i++) {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                    nodeList.add(node.val);
                }
                if (reverseLevel)
                    Collections.reverse(nodeList);
                reverseLevel = !reverseLevel;
                result.add(nodeList);
            }
            return result;
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
