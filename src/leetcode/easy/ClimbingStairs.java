package leetcode.easy;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(Solution.climbStairs(8));
    }

    static class Solution {
        public static int climbStairs(int n) {
            return climbStairsBruteForce(0, n);
        }

        public static int climbStairsBruteForce(int i, int n){
            if(i > n){
                return 0;
            }
            if(n == i){
                return 1;
            }
            return climbStairsBruteForce(i+1, n) + climbStairsBruteForce(i+2, n);
        }

        public int climbStairsBruteForceWithMemoization(int n) {
            int[] memo = new int[n+1];
            return climbStairsMemo(0, n, memo);
        }

        public int climbStairsMemo(int i, int n, int[] memo){
            if(i > n){
                return 0;
            }
            if(n == i){
                return 1;
            }
            if(memo[i] > 0){
                return memo[i];
            }
            memo[i] = climbStairsMemo(i+1, n, memo) + climbStairsMemo(i+2, n, memo);
            return memo[i];
        }

        public int climbStairsDP(int n) {
            if(n == 1){
                return 1;
            }
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i<=n; i++){
                dp[i] = dp[i-1]+dp[i-2];
            }
            return dp[n];
        }


        public int climbStairsFibonacci(int n) {
            if(n == 1){
                return 1;
            }
            int first = 1;
            int second = 2;
            for (int i = 3; i <= n; i++){
                int third = first + second;
                first = second;
                second = third;
            }
            return second;
        }
    }
}