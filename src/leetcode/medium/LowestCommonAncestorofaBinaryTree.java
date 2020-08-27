package leetcode.medium;

public class LowestCommonAncestorofaBinaryTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = node1.left = new TreeNode(5);
        TreeNode node3 = node1.right = new TreeNode(1);
        TreeNode node4 = node2.left = new TreeNode(6);
        TreeNode node5 = node2.right = new TreeNode(2);
        TreeNode node6 = node3.left = new TreeNode(0);
        TreeNode node7 = node3.right = new TreeNode(8);
        TreeNode node8 = node5.left = new TreeNode(7);
        TreeNode node9 = node5.right = new TreeNode(4);

//        System.out.println(Solution.lowestCommonAncestor(node1, node2, node3));

    }

    static class Solution {

        private TreeNode ans;

        public Solution() {
            this.ans = null;
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            helper(root, p, q);
            return this.ans;
        }

        private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return false;

            int left = helper(root.left, p, q)? 1 : 0;
            int right = helper(root.right, p, q)? 1 : 0;
            int mid = (root == p || root == q)? 1 : 0;

            if(left + right + mid >= 2) {
                this.ans = root;
            }
            return (left + right + mid > 0);
        }
    }

    class SolutionRecusiveSelf {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left != null && right != null)
                return root;
            if(left != null)
                return left;
            if(right != null)
                return right;

            return null;
        }
    }
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
