package leetcode.review.leetcode.medium;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(Solution.canPartition(new int[] {1,2,3,5}));
    }

    static class Solution {
        public boolean canPartition(int[] nums) {
            if(nums == null || nums.length == 0) {
                return false;
            }
            int sum = 0;
            for(int num : nums) {
                sum += num;
            }
            if(sum % 2 == 1) {
                return false;
            }
            int target = sum/2;
            int[] dp = new int[target+1];

            return backtracking(nums, dp, 0, 0, target);
        }
        private boolean backtracking(int[] nums, int[] dp, int idx, int cur, int target) {
            if(cur == target) {
                return true;
            }
            if(idx >= nums.length || cur > target) {
                return false;
            }
            if(dp[cur] == 1) {
                return true;
            }
            if(dp[cur] == -1) {
                return false;
            }
            boolean res = backtracking(nums, dp, idx+1, cur+nums[idx], target) || backtracking(nums, dp, idx+1, cur, target);
            dp[cur] = res ? 1 : -1;
            return res;
        }
    }

    // Time limit exception... need to memoization
    static class MySolution {
        public static boolean canPartition(int[] nums) {
            if(nums.length == 0) return false;

            int target = 0;
            for(int num : nums) {
                target += num;
            }

            if(target % 2 > 0) return false;
            target = target / 2;

            return helper(nums, 0, target);
        }

        private static boolean helper(int[] nums, int idx, int target) {
            if(target == 0) {
                return true;
            }

            if(target < 0 || idx >= nums.length) {
                return false;
            }

            return helper(nums, idx+1, target - nums[idx]) || helper(nums, idx+1, target);
        }
    }
}
