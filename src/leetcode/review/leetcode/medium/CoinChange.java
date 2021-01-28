package leetcode.review.leetcode.medium;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(Solution.coinChange(new int[]{1,2,5}, 11));
    }

    static class Solution {
        public static int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[max];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] == max ? -1 : dp[amount];
        }
    }
}
