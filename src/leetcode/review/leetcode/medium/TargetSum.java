package leetcode.review.leetcode.medium;

public class TargetSum {

    public static void main(String[] args) {
        System.out.println(Solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    static class Solution {
        public static int findTargetSumWays(int[] nums, int S) {
            int[] dp = new int[2001];
            dp[nums[0] + 1000] = 1;
            dp[-nums[0] + 1000] += 1;
            for (int i = 1; i < nums.length; i++) {
                int[] next = new int[2001];
                for (int sum = -1000; sum <= 1000; sum++) {
                    if (dp[sum + 1000] > 0) {
                        next[sum + nums[i] + 1000] += dp[sum + 1000];
                        next[sum - nums[i] + 1000] += dp[sum + 1000];
                    }
                }
                dp = next;
            }
            return S > 1000 ? 0 : dp[S + 1000];
        }
    }

    static class SolutionBest {
        public static int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for(int n:nums) sum+=n;
            if((sum+S)%2!=0 || sum<S) return 0;
            int target = (sum+S)/2;
            return subsetSum(nums, target);
        }

        public static int subsetSum(int[] nums, int target) {
            int[] dp = new int[target+1];
            dp[0] = 1;
            for(int num:nums) {
                for(int i=target;i>=num;i--) {
                    dp[i]+=dp[i-num];
                }
            }
            return dp[target];
        }
    }

    static class MySolution {
        public static int findTargetSumWays(int[] nums, int S) {
            return helper(nums, S, 0);
        }

        private static int helper(int[] nums, int S, int idx) {

            if(idx >= nums.length) {
                return (S == 0)? 1: 0;
            }

            return helper(nums, S - nums[idx], idx+1) + helper(nums, S + nums[idx], idx+1);
        }
    }
}
