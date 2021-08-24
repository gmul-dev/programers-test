package leetcode.medium;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] params = new int[][]{
            {1, 3, 1},
            {1, 1, 1},
            {4, 2, 1}
        };
        System.out.println(SolutionDP.minPathSum(params));
    }

    static class Solution {
        public static int minPathSum(int[][] grid) {
//            if(grid.length == 0) return 0;
//
//            int[][] dp = new int[grid.length][];
//            int max = 0;
//
//            for(int i = 0; i < grid.length; i++) {
//                for(int j = 0; j < grid[0].length; j++) {
//                    if(i == 0 && j == 0) {
//                        dp[i][j] = grid[i][j];
//                    }
//
//                    dp[i][j] =
//                }
//            }
            return 0;
        }
    }

    static class SolutionDP {
        public static int minPathSum(int[][] grid) {

            int rows = grid.length;
            int cols = grid[0].length;

            for(int i = 1; i < rows; i++) {
                grid[i][0] += grid[i - 1][0];
            }

            for(int j = 1; j < cols; j++) {
                grid[0][j] += grid[0][j - 1];
            }

            for(int i = 1; i < rows; ++i){
                for(int j = 1; j < cols; ++j){
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
            return grid[rows-1][cols-1];
        }
    }
}
