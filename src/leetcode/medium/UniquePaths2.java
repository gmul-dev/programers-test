package leetcode.medium;


public class UniquePaths2 {

    public static void main(String[] args) {
        int[][] param = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(Solution.uniquePathsWithObstacles(param));
    }

    static class Solution {
        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if(obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
                return 0;
            }
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m+1][n+1];
            for(int i = 0; i < obstacleGrid.length; i++) {
                for(int j = 0; j < obstacleGrid[0].length; j++) {
                    if(obstacleGrid[i][j] > 0) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if(i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }
    }
    class Solution2 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[][] dp = new int[m+1][n+1];
            if(obstacleGrid[0][0]==0)
                dp[1][1] = 1;

            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(i==1 && j==1)
                        continue;
                    if(obstacleGrid[i-1][j-1]==0){
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }

            return dp[m][n];
        }
    }

    class Solution3 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length,n=obstacleGrid[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(obstacleGrid[i][j]==1) obstacleGrid[i][j]=0;
                    else if(i==0 && j==0) obstacleGrid[i][j]=1;
                    else if(i==0) obstacleGrid[i][j] =obstacleGrid[i][j-1]*1;
                    else if(j==0) obstacleGrid[i][j]= obstacleGrid[i-1][j]*1;
                    else  obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
            return obstacleGrid[m-1][n-1];
        }
    }
}
