package leetcode;

import java.util.LinkedList;

public class MaximumDepthBinaryTree {
    public static void main(String[] args) {
        System.out.println(SolutionMemoryBest.maxDepth(new TreeNode(3, new TreeNode(9, null, null), new TreeNode( 20, new TreeNode(15, null, null), new TreeNode(17, null, null)))));
    }

    static class Solution {
        public static int maxDepth(TreeNode root) {
            if(root==null)
                return 0;
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            return (Math.max(left,right)+1);
        }
    }

    static class SolutionMemoryBest {
        public static int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> depths = new LinkedList<>();
            stack.add(root);
            depths.add(1);
            int depth = 0, currDepth = 0;
            while(!stack.isEmpty()){
                TreeNode currNode = stack.pollLast();
                currDepth = depths.pollLast();
                if(currNode != null){
                    depth = Math.max(depth, currDepth);
                    stack.add(currNode.left);
                    stack.add(currNode.right);
                    depths.add(currDepth + 1);
                    depths.add(currDepth + 1);
                }
            }
            return depth;
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
