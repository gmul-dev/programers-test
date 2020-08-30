package leetcode.medium;

public class Searcha2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(Solution.searchMatrix(matrix, 20));
    }

    static class Solution {
        public static boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int m = matrix.length - 1;
            int n = 0;

            while (m >= 0 && n < matrix[0].length) {
                if(matrix[m][n] == target) return true;
                else if(matrix[m][n] < target) n++;
                else m--;
            }

            return false;
        }
    }
}
