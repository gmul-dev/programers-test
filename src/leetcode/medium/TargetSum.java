package leetcode.medium;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        System.out.println(SolutionDPBest.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

     static class Solution {
        int count = 0;
        public static int findTargetSumWays(int[] nums, int S) {
            int[][] memo = new int[nums.length][2001];
            for (int[] row: memo)
                Arrays.fill(row, Integer.MIN_VALUE);
            return calculate(nums, 0, 0, S, memo);
        }
        public static int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
            if (i == nums.length) {
                if (sum == S)
                    return 1;
                else
                    return 0;
            } else {
                if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                    return memo[i][sum + 1000];
                }
                int add = calculate(nums, i + 1, sum + nums[i], S, memo);
                int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
                memo[i][sum + 1000] = add + subtract;
                return memo[i][sum + 1000];
            }
        }
    }

    static class SolutionDPBest {
        public static int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int num : nums)
                sum += num;
            if (sum < S || -sum > -S || (S + sum) % 2 != 0)
                return 0;

            int target = (S + sum) / 2, dp[] = new int[target + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = target; i >= num; i--)
                    dp[i] += dp[i - num];
            }
            return dp[target];
        }
    }

    class SolutionDP {
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (S > sum || sum < -S) {
                return 0;
            }

            if ((S + sum) % 2 != 0) {
                return 0;
            }

            int len = nums.length;
            int target = (S + sum) / 2;

            int[] dp = new int[target + 1];

            dp[0] = 1;
            for (int i = 1; i <= len; i++) {
                for (int j = target; j >= nums[i - 1]; j--) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }
            }

            return dp[target];
        }
    }
}
