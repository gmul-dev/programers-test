package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(SolutionDFS.coinChange(new int[]{1,2,5}, 11));
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

    static class SolutionDFS {
        public static int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            int[] min =  new int[]{Integer.MAX_VALUE};
            helper(coins, coins.length - 1, amount, min, 0);
            return (min[0] == Integer.MAX_VALUE)? - 1 : min[0];
        }

        private static void helper(int[] coins, int index, int amount, int[] min, int count) {
            if(amount < 0) {
                return;
            }

            for(int num = amount / coins[index]; num >= 0; num--) {
                int remain = amount - num * coins[index];
                if(remain == 0) {
                    min[0] = Math.min(min[0], num + count);
                }

                if(count + num + 1 < min[0] && index > 0) {
                    helper(coins, index - 1, remain, min, count + num);
                } else {
                    return;
                }
            }
        }
    }
}
