package leetcode.medium;

public class MaximumProductSubarray {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 0)
                return 0;
            if (nums.length == 1)
                return nums[0];
            int res = nums[0];
            int curMax = nums[0];
            int curMin = nums[0];

            for (int i=1;i<nums.length;i++){
                int nextMax = nums[i] * curMax;
                int nextMin = nums[i] * curMin;
                curMax = Math.max(nums[i], Math.max(nextMax , nextMin));
                curMin = Math.min(nums[i], Math.min(nextMax, nextMin));
                res = Math.max(curMax,res);
            }
            return res;
        }
    }

    class SolutionBest {
        public int maxProduct(int[] nums) {
            int product = 1;
            int maxProduct = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++) {
                product *= nums[i];
                maxProduct = Math.max(product, maxProduct);
                if(product == 0) product = 1;
            }

            product = 1;
            for(int i = nums.length - 1; i > 0; i--) {
                product *= nums[i];
                maxProduct = Math.max(product, maxProduct);
                if(product == 0) product = 1;
            }

            return maxProduct;
        }
    }
}
