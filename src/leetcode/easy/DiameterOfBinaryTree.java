package leetcode.easy;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = node1.left = new TreeNode(2);
        TreeNode node3 = node1.right = new TreeNode(3);
        TreeNode node4 = node2.left = new TreeNode(4);
        TreeNode node5 = node2.right = new TreeNode(5);
        System.out.println(Solution.diameterOfBinaryTree(node1));
    }

    static class Solution {
        static int ans;
        public static int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }
        public static int depth(TreeNode node) {
            if (node == null) return 0;
            int L = depth(node.left);
            int R = depth(node.right);
            ans = Math.max(ans, L+R+1);
            return Math.max(L, R) + 1;
        }
    }

    class Solution1 {
        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null) return 0;

            diameterRec(root);

            return max;
        }

        private int diameterRec(TreeNode node) {
            if(node == null) return 0;
            if(node.left == null && node.right == null) {
                return 1;
            }
            int left = diameterRec(node.left);
            int right = diameterRec(node.right);

            max = Math.max(max, left + right);
            return Math.max(left,right) + 1;
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
