package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;

// inorder
public class KthSmallestElementinaBST {

    public static void main(String[] args) {
//        System.out.println(Solution.kthSmallest());
    }

    class SolutionRecusiveInorder {
        public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
            if(root == null) return arr;
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
            return arr;
        }

        public int kthSmallest(TreeNode root, int k) {
            ArrayList<Integer> arr = inorder(root, new ArrayList<>());
            return arr.get(k-1);
        }
    }


    class SolutionIterativeInorder {
        public int kthSmallest(TreeNode root, int k) {
            LinkedList<TreeNode> stack = new LinkedList<>();

            while (true) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.removeLast();
                if(--k == 0) return root.val;
                root = root.right;
            }
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
