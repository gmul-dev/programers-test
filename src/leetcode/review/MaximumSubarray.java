package leetcode.review;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(Solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    static class Solution {
        public static int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int sum = 0;

            for(int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                if(max < sum) max = sum;
                if(sum < 0) sum = 0;
            }
            return max;
        }

        public static int maxSubArray1(int[] nums) {
            // Kadane's algorithm
            //  O(n)
            int longest = nums[0], cur = nums[0];
            for (int i = 1; i < nums.length; i++) {
                cur = Math.max(nums[i], cur + nums[i]);
                longest = Math.max(longest, cur);
            }
            return longest;
        }
    }
}
