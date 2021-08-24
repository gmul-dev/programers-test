package leetcode.medium;


public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(Solution.uniquePaths(23,12));
    }

    //경우의 수
    //FORMULA:
    //(m+n-2)! / (n-1)! (m-1)!
    static class Solution {
        public static int uniquePaths(int m, int n) {
//            double dividend = 1, divisor = 1;
//            double max = Math.max(m - 1, n - 1);
//            double min = Math.max(m - 1, n - 1);
//
//            for(double i = max + 1; i < (m + n - 1); i++) {
//                dividend *= i;
//            }
//
//            for(double i = 2; i <= min; i++) {
//                divisor *= i;
//            }
//
//            return (int) (dividend/divisor);

//            long path = 1;
//            for (int i = n; i < (m + n - 1); i++) {
//                path *= i;
//                path /= (i - n + 1);
                  /* for n부터 시작 : -n, m-1 팩토리얼 시작값은 1 : +1, 팩토리얼 증가분 +i -> 1 * 2 * ... * m-1 */
//            }
//            return (int)path;

            int N = m + n - 2;
            int k = n - 1;

            double res = 1;
            for (int i=1; i<=k; i++) {
                res = res * (N-k+i)/i;
            }
            return (int)res;
        }
    }

    class SolutionDP {
        public int uniquePaths(int m, int n) {
            //The idea is to calculate the number of ways to reach a cell.
            // dp[row][col] = dp[row-1][col]+dp[row][col-1]

            int [][]dp = new int[m+1][n+1];
            for(int i = 0;i < m; i++){
                for(int j = 0;j<n;j++){
                    // if(i == 0 && j == 0) dp[i][j] = 1;
                    // if its the topmost row or leftmost column, that cell will always be 1
                    if(i == 0 || j == 0 ) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }
    }
}
