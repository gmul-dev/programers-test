package leetcode.easy;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(Solution.rob(new int[]{2,7,9,3,1}));
    }

    static class Solution {
        public static int rob(int[] nums) {
            int preMax = 0;
            int max = 0;
            for (int num : nums){
                int temp = max;
                max = Math.max(preMax + num, max);
                preMax = temp;
            }
            return max;
        }
    }
}
