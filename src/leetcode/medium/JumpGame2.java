package leetcode.medium;

public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(Solution.jump(new int[]{2,3,1,1,4}));
    }

    static class Solution {
        public static int jump(int[] nums) {
            if(nums == null || nums.length == 0) return 0;

            int max = 0;
            int cMax = 0;
            int jumps = 0;

            for(int i=0; i<nums.length-1; i++){

                max = Math.max(max, i+nums[i]);

                if(i == cMax){
                    cMax = max;
                    jumps++;
                }
            }
            return jumps;
        }
    }
}
