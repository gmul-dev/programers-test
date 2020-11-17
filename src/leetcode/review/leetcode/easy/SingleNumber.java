package leetcode.review.leetcode.easy;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(Solution.singleNumber(new int[]{4,1,2,1,2}));
    }

    static class Solution {
        public static int singleNumber(int[] nums) {
//            int singleNum = 0;
//            for(int num : nums) {
//                singleNum ^= num;
//            }
//            return singleNum;

            int n = nums.length;
            int ans = 0;
            for(int i=0;i<n;i++){
                ans = ans^nums[i];
            }
            return ans;
        }
    }
}
