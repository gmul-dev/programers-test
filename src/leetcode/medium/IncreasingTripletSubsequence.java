package leetcode.medium;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println(Solution.increasingTriplet(new int[]{0,4,2,1,0,-1,-3}));
    }

    static class Solution {
        public static boolean increasingTriplet(int[] nums) {
            if(nums.length == 0)
                return true;

            int min = nums[0];
            int max = nums[nums.length - 1];
            for(int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                if(min < cur && cur < max) {
                    return true;
                }

                if(min > cur) {
                    min = cur;
                }

                if(max < cur) {
                    max = cur;
                }
            }
            return false;
        }
    }

    class SolutionBest {
        public boolean increasingTriplet(int[] nums) {
            int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

            for(int i : nums) {
                if(i <= small)
                    small = i;
                else if(i <= mid)
                    mid = i;
                else
                    return true;
            }
            return false;
        }
    }

    //Your algorithm should run in O(n) time complexity and O(1) space complexity.
}
