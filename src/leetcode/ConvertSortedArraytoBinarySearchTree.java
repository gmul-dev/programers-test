package leetcode;

public class ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(Solution.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

    static class Solution {
        public static TreeNode sortedArrayToBST(int[] nums) {
            return getBST(nums, 0, nums.length-1);
        }

        public static TreeNode getBST(int nums[], int s, int e) {
            if(s > e) return null;

            int mid = (s + e) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = getBST(nums, s, mid-1);
            node.right = getBST(nums, mid+1, e);
            return node;
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
