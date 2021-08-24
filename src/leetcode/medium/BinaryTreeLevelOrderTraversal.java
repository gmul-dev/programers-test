package leetcode.medium;

import org.omg.PortableInterceptor.INACTIVE;

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
            if(root==null) {
                return new ArrayList();
            }
            List<List<Integer>> al = new ArrayList();

            Queue<TreeNode> q = new LinkedList();
            q.add(root);

            while(!q.isEmpty()) {
                int cnt = q.size();
                List<Integer> l1 = new ArrayList();
                for(int i = 0; i < cnt; i++) {
                    TreeNode u = q.poll();
                    l1.add(u.val);
                    if(u.left != null) {
                        q.add(u.left);
                    }
                    if(u.right != null) {
                        q.add(u.right);
                    }
                }
                al.add(l1);
            }
            return al;
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
