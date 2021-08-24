package leetcode.review.leetcode.medium;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = node1.left = new TreeNode(9);
        TreeNode node3 = node1.right = new TreeNode(20);
        TreeNode node4 = node3.left = new TreeNode(15);
        TreeNode node5 = node3.right = new TreeNode(7);
        System.out.println(Solution.levelOrder(node1));
    }

    static class Solution {
        public static List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            traverse(root, res, 0);
            return res;
        }

        private static void traverse(TreeNode tree, List<List<Integer>> list, Integer height) {
            if(tree == null) return;
            if(height >= list.size()) {
                list.add(new LinkedList<Integer>());
            }
            list.get(height).add(tree.val);
            traverse(tree.left, list, height+1);
            traverse(tree.right, list, height+1);
        }
    }

    static class MySolution {
        public static List<List<Integer>> levelOrder(TreeNode root) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            helper(root, map, 0);
            return new ArrayList(map.values());
        }

        private static void helper(TreeNode node, Map<Integer, List<Integer>> map, int level) {
            if(node == null) return;

            if (!map.containsKey(level)) map.put(level, new ArrayList());
            map.get(level).add(node.val);
            helper(node.left, map, level+1);
            helper(node.right, map, level+1);
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
