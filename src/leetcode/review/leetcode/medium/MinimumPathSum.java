package leetcode.review.leetcode.medium;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] params = new int[][]{
                {1, 3, 1},
                {1, 1, 1},
                {4, 2, 1}
        };
        System.out.println(SolutionRecusive.minPathSum(params));
    }

    static class SolutionRecusive {
        public static int minPathSum(int[][] grid) {
            int[][] memo = new int[grid.length][grid[0].length];
            return helper(grid, memo, grid.length-1, grid[0].length-1);
        }

        private static int helper(int[][] grid, int[][] memo, int i, int j) {

            if(i == 0 && j == 0) {
                return grid[i][j];
            }
            if(memo[i][j] != 0) {
                return memo[i][j];
            }
            if(i == 0) {
                memo[i][j] = grid[i][j] + helper(grid, memo, i, j-1);
                return memo[i][j];
            }
            if(j == 0) {
                memo[i][j] = grid[i][j] + helper(grid, memo, i-1, j);
                return memo[i][j];
            }

            memo[i][j] = grid[i][j] + Math.min(helper(grid, memo, i, j-1), helper(grid, memo, i-1, j));
            return memo[i][j];
        }

    }

    class SolutionIterator {
        public int minPathSum(int[][] grid) {
            if(grid.length == 0)
                return 0;

            int[][] dp = new int[grid.length][grid[0].length];

            for(int i = 0; i < dp.length; i++) {
                for(int j = 0; j < dp[0].length; j++) {
                    dp[i][j] += grid[i][j];

                    if(i > 0 && j > 0) {
                        dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                    } else if(i > 0) {
                        dp[i][j] += dp[i-1][j];
                    } else if(j > 0) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
            return dp[dp.length-1][dp[0].length-1];
        }
    }


}
