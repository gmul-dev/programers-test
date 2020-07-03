package leetcode.easy;

import java.util.Stack;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode firstNode1 = new TreeNode(1);
        TreeNode firstNode2 = firstNode1.left = new TreeNode(3);
        TreeNode firstNode3 = firstNode1.right = new TreeNode(2);
        TreeNode firstNode4 = firstNode2.left = new TreeNode(5);

        TreeNode secondNode1 = new TreeNode(2);
        TreeNode secondNode2 = secondNode1.left = new TreeNode(1);
        TreeNode secondNode3 = secondNode1.right = new TreeNode(3);
        TreeNode secondNode4 = secondNode2.right = new TreeNode(4);
        TreeNode secondNode5 = secondNode3.right = new TreeNode(7);

        System.out.println(Solution.mergeTrees(firstNode1, secondNode1));
    }

    static class Solution {
        public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null && t2 == null)
                return null;

            TreeNode left = mergeTrees(t1.left, t2.left);
            //-> t1.left
            TreeNode right = mergeTrees(t1.right, t2.right);
            //-> t1.right
            if(left == null && right != null) {
                return new TreeNode(right.val);
            } else if(left != null && right == null) {
                return left;
            } else {
                left.val += right.val;
                return left;
            }
        }
    }

    static class SolutionRecusive {
        public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null)
                return t2;
            if (t2 == null)
                return t1;
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

    class SolutionStack {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null)
                return t2;
            Stack< TreeNode[] > stack = new Stack < > ();
            stack.push(new TreeNode[] {t1, t2});
            while (!stack.isEmpty()) {
                TreeNode[] t = stack.pop();
                if (t[0] == null || t[1] == null) {
                    continue;
                }
                t[0].val += t[1].val;
                if (t[0].left == null) {
                    t[0].left = t[1].left;
                } else {
                    stack.push(new TreeNode[] {t[0].left, t[1].left});
                }
                if (t[0].right == null) {
                    t[0].right = t[1].right;
                } else {
                    stack.push(new TreeNode[] {t[0].right, t[1].right});
                }
            }
            return t1;
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
