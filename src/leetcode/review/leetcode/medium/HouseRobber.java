package leetcode.review.leetcode.medium;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(MySolution.rob(new int[]{2,7,9,3,1}));
    }

    class SolutionIterator {
        public int rob(int[] nums) {
            if(nums==null||nums.length==0) return 0;
            int rob=0, no_rob=0;
            for(int num : nums) {
                int prev_rob=rob;
                rob = Math.max(rob, no_rob+num);
                no_rob=prev_rob;
            }
            return rob;
        }
    }

    static class MySolution {
        public static int rob(int[] nums) {
            return helper(nums, 0, 0, 0);
        }

        private static int helper(int[] nums, int idx, int rob, int notRob) {
            if(idx >= nums.length) {
                return Math.max(rob, notRob);
            }

            return helper(nums, idx+1, notRob + nums[idx], Math.max(rob, notRob));
        }
    }


}
