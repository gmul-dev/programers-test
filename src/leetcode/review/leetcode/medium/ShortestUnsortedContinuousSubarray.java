package leetcode.review.leetcode.medium;

public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        System.out.println(Solution.findUnsortedSubarray(new int[]{5,2,8,7,3,6}));
    }

    static class Solution {
        public static int findUnsortedSubarray(int[] nums) {
            int start = 0, end = -1;
            int min = nums[nums.length - 1], max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(nums[i], max);
                min = Math.min(nums[nums.length - i - 1], min);
                if (nums[i] < max) end = i;
                if (nums[nums.length - i - 1] > min) start = nums.length - i - 1;
            }

            return end - start + 1;
        }
    }


    class SolutionStack {
        public int findUnsortedSubarray(int[] nums) {
            int end = 0;
            int num = nums[0];

            for(int i = 1; i < nums.length; i++) {
                if(nums[i] <= num) {
                    num = nums[i];
                } else {
                    end = i;
                }
            }

            int start = nums.length;
            num = nums[nums.length - 1];

            for(int j = nums.length - 2; j >= 0; j--) {
                if(nums[j] <= num) {
                    num = nums[j];
                } else {
                    start = j;
                }
            }
            if (start == nums.length) {
                return 0;
            }
            return end - start + 1;
        }
    }
}
