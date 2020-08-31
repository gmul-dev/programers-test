package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(Solution.numSquares(13));
    }

    static class Solution {

        // dp with memoization
        static ArrayList<Integer> dp = new ArrayList<>();
        public static int numSquares(int n) {
            if(dp.size() == 0) {
                dp.add(0);
            }

            if(dp.size() <= n){
                for (int i = dp.size(); i <= n; i++) {
                    int min = Integer.MAX_VALUE;
                    for (int j = 1; j * j <= i; j++) {
                        min = Math.min(min, dp.get(i - j * j) + 1);
                    }
                    dp.add(min);
                }
            }
            return dp.get(n);
        }

        public int numSquares1(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, n);
            dp[0] = 0;

            for(int i = 1; i <= n; i++){
                for(int j = 1; j * j <= i; j++){
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }

    class SolutionTheorems {

        protected boolean isSquare(int n) {
            int sq = (int) Math.sqrt(n);
            return n == sq * sq;
        }

        public int numSquares(int n) {
            // four-square and three-square theorems.
            while (n % 4 == 0)
                n /= 4;
            if (n % 8 == 7)
                return 4;

            if (this.isSquare(n))
                return 1;
            // enumeration to check if the number can be decomposed into sum of two squares.
            for (int i = 1; i * i <= n; ++i) {
                if (this.isSquare(n - i * i))
                    return 2;
            }
            // bottom case of three-square theorem.
            return 3;
        }
    }
}
