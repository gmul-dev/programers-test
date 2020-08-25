package leetcode.medium;

public class MaximalSquare {

    public static void main(String[] args) {

    }

    class Solution {
        public int maximalSquare(char[][] matrix) {
//            int m = matrix.length;
//            int n = m == 0? 0:matrix[0].length;
//            int[] dp = new int[n+1];
//            int max = 0;
//
//            int prev = 0;
//            for(int i = 0; i<m;i++){
//                for(int j = 0; j<n;j++){
//                    int tmp = dp[j+1];
//                    if(matrix[i][j] == '1'){
//                        dp[j+1] = Math.min(prev, Math.min(dp[j], dp[j+1])) + 1;
//                        max = Math.max(dp[j+1], max);
//                    }
//                    else
//                        dp[j+1] = 0;
//
//                    prev = tmp;
//                }
//            }
//
//            return max * max;

            // [prev] [dp[j]]
            // [dp[j-1]] [new dp[j]]
            // prev -> 대각선으로 이동
            int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
            int[] dp = new int[cols+1];
            int maxsqlen = 0, prev = 0;

            for(int i = 1; i <= rows; i++) {
                for(int j = 1; j <= cols; j++) {
                    int temp = dp[j];
                    if(matrix[i-1][j-1] == '1') {
                        dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
                        maxsqlen = Math.max(maxsqlen, dp[j]);
                    } else {
                        dp[j] = 0;
                    }
                    prev = temp;
                }
            }

            return maxsqlen * maxsqlen;
        }
    }
}
