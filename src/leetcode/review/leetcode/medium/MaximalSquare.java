package leetcode.review.leetcode.medium;

public class MaximalSquare {

    public static void main(String[] args) {
        System.out.println(Solution.maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}}));
    }

    static class Solution {
        public static int maximalSquare(char[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            int max = 0;
            int[][] dp = new int[row+1][col+1];
            for(int i = 1; i <= row; i++) {
                for(int j = 1; j <= col; j++) {
                    if(matrix[i-1][j-1] == '1') {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                        max = Math.max(dp[i][j], max);
                    }
                }
            }
            return max*max;
        }
    }

}
