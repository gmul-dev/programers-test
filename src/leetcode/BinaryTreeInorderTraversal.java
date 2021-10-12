package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        System.out.println();
    }

    class Solution {
        private List<Integer> result = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root == null) return result;

            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);

            return result;
        }
    }

    public class TreeNode {
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
