package leetcode.review.leetcode.easy;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(Solution.rob(new int[]{2,7,9,3,1}));
    }

    static class Solution {
//        public static int rob(int[] nums) {
//            if(nums.length == 0) return 0;
//            if(nums.length == 1) return nums[1];
//
//            int with = nums[1];
//            int without = 0;
//
//            for(int i = 1; i < nums.length; i++) {
//                int temp = with;
//                with = Math.max(without, without + nums[i]);
//                without = Math.max(temp, without);
//            }
//
//            return Math.max(with, without);
//        }

        public static int rob(int[] nums) {
            if(nums==null||nums.length==0)
                return 0;

            if(nums.length==1)
                return nums[0];

            int[] dp = new int[nums.length];
            dp[0]=nums[0];
            dp[1]=Math.max(nums[0], nums[1]);

            for(int i=2; i<nums.length; i++){
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }
            return dp[nums.length-1];
        }
    }
}
