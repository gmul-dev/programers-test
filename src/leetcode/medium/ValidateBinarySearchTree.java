package leetcode.medium;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = node1.left = new TreeNode(5);
        TreeNode node3 = node1.right = new TreeNode(15);
        TreeNode node4 = node3.left = new TreeNode(6);
        TreeNode node5 = node3.right = new TreeNode(20);

        System.out.println(Solution.isValidBST(node1));
    }

    static class Solution {
        //아래 노드의 값이 윗 노드보다 클때 성립하지 않음
        public static boolean isValidBST(TreeNode root) {
            if(root == null)
                return true;

            if(root.left != null && root.val <= root.left.val){
                return false;
            }

            if(root.right != null && root.val >= root.right.val){
                return false;
            }

            return isValidBST(root.left) && isValidBST(root.right);
        }
    }

    class SolutionRecursion {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) return true;
            if (root.val >= maxVal || root.val <= minVal) return false;
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }
    }

    class SolutionRecursion2 {
        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null) return true;

            int val = node.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;

            if (! helper(node.right, val, upper)) return false;
            if (! helper(node.left, lower, val)) return false;
            return true;
        }

        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
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
