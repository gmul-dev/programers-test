package leetcode.review.leetcode.medium;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(Solution.canJump(new int[]{2,3,1,1,4}));
    }

    static class Solution {
        public static boolean canJump(int[] nums) {
            int lastPosition = nums.length - 1;
            for(int i = nums.length - 1; i >= 0; i--) {
                if(i + nums[i] >= lastPosition) {
                    lastPosition = i;
                }
            }
            return lastPosition == 0;
        }
    }

    class SolutionDP {
        public boolean canJump(int[] nums) {
            if(nums == null || nums.length <= 1)
                return true;
            if(nums[0] == 0)
                return false;

            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = 1;

            for(int i = 1; i<len; i++)
            {
                dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
                if(dp[i] < 0)
                    return false;
            }

            return true;
        }
    }
}
