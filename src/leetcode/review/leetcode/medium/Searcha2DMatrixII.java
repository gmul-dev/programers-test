package leetcode.review.leetcode.medium;

public class Searcha2DMatrixII {

    public static void main(String[] args) {
        System.out.println(Solution.searchMatrix(new int[][] {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}},
            20));
    }

    static class Solution {
        public static boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int row = 0, col = matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {
                if (matrix[row][col] == target) return true;
                if (matrix[row][col] > target) col--;
                else row++;
            }
            return false;
        }
    }
}
