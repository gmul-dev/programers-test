package leetcode.review.leetcode.medium;

public class ProductofArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Solution.productExceptSelf(new int[]{1,2,3,4}));
    }

    static class Solution {
        public static int[] productExceptSelf(int[] nums) {
            if(nums == null || nums.length == 0)
                return null;

            int n = nums.length;
            int[] left = new int[n];
            int[] right = new int[n];
            int[] ans = new int[n];

            left[0] = 1;
            for(int i=1; i<n; i++) {
                left[i] = nums[i-1] * left[i-1];
            }

            right[n-1] = 1;
            for(int i=n-2; i>=0; i--) {
                right[i] = nums[i+1] * right[i+1];
            }

            for(int i=0; i<n; i++)
                ans[i] = left[i] * right[i];

            return ans;

        }
    }

    static class MySolution {
        public static int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] result = new int[length];

            int sum = nums[0];
            nums[0] = 1;
            for(int i = 1; i < length; i++) {
                result[i] = sum;
                sum *= nums[i];
            }

            sum = nums[length - 1];
            for(int i = length - 2; i >= 0; i--) {
                result[i] *= sum;
                sum *= nums[i];
            }

            return result;
        }
    }
}
