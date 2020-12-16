package leetcode.review.leetcode.medium;

public class FlattenBinaryTreetoLinkedList {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = node1.left = new TreeNode(2);
        TreeNode node3 = node1.right = new TreeNode(5);
        TreeNode node4 = node2.left = new TreeNode(3);
        TreeNode node5 = node2.right = new TreeNode(4);
        TreeNode node6 = node3.right = new TreeNode(6);
        Solution solution = new Solution();
        solution.flatten(node1);
    }

    static class MySolution {
        public static void flatten(TreeNode root) {
            if(root == null)
                return;
            flatten(root.left);
            flatten(root.right);

            root.left.right = root.right;

            root.right = root.left;
            root.left = null;
        }

        public void flattenIWant(TreeNode root) {
            if (root == null) return;
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode tmp = root;
            flatten(root.left);
            flatten(root.right);
            root.left = null;
            root.right = left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = right;
        }
    }

    static class Solution {

        private TreeNode prev = null;
        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }

        //iterative

  /*  TreeNode curr = root;

    while (curr != null) {
        if (curr.left != null) {
             TreeNode pre = curr.left;
        while (pre.right != null) {
            pre = pre.right;
        }

        pre.right = curr.right;
        curr.right = curr.left;
        curr.left = null;
        }
       curr = curr.right;
    }
   }*/
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


