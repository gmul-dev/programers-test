package leetcode.review.leetcode.medium;

import java.util.ArrayList;

public class KthSmallestElementinaBST {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = node1.left = new TreeNode(1);
        TreeNode node3 = node1.right = new TreeNode(4);
        TreeNode node4 = node2.right = new TreeNode(2);
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(node1, 1));
    }

    static class MySolution {
        public static int kthSmallest(TreeNode root, int k) {
            if (root == null)
                return 0;
            if (k == 0)
                return root.val;

            if (root.left != null) {
                kthSmallest(root.left, k);
            }

            k--;

            if (root.right != null) {
                kthSmallest(root.right, k);
            }

            return 0;
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

class Solution {

    int count,result;
    public void preOrderAlt(KthSmallestElementinaBST.TreeNode root, int k) {
        if(root==null) return;
        preOrderAlt(root.left, k);
        count++;
        if(k==count) result= root.val;
        preOrderAlt(root.right, k);
    }
    public int kthSmallest(KthSmallestElementinaBST.TreeNode root, int k) {
        count=0;
        preOrderAlt(root, k);
        return result;
    }

//        public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
//            if (root == null) return arr;
//            inorder(root.left, arr);
//            arr.add(root.val);
//            inorder(root.right, arr);
//            return arr;
//        }
//
//        public int kthSmallest(TreeNode root, int k) {
//            ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
//            return nums.get(k - 1);
//        }
}