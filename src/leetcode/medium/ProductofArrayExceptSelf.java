package leetcode.medium;

public class ProductofArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Solution.productExceptSelf(nums));
    }

    static class Solution {
        public static int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];
            int sum = nums[0];
            result[0] = 1;

            for(int i = 1; i < nums.length; i++) {
               result[i] = sum;
               sum *= nums[i];
            }

            sum = nums[nums.length - 1];
            for(int i = nums.length - 2; i >= 0; i--) {
                result[i] *= sum;
                sum *= nums[i];
            }
            return result;
        }
    }
}
