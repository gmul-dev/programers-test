package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class MaximumSubarray {
    public static void main(String[] args) {
       // System.out.println(Solution.isValid("([])"));
        System.out.println(Solution.maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    static class Solution {
        public static int maxSubArray(int[] nums) {
            int sum = 0;
            int maxSum = -9999999;
            int nonContMaxSum = 0;
            int maxNeg = -9999999;

            for(int i = 0; i < nums.length; i++)
            {
                sum += nums[i];
                if(sum > maxSum)
                    maxSum = sum;
                if(sum < 0)
                    sum = 0;
                if(nums[i]>0)
                    nonContMaxSum += nums[i];
                if(maxNeg < nums[i])
                    maxNeg = nums[i];
            }

            //1. 원소가 연속된 부분배열의 최대합
            System.out.print(Math.max(maxSum,maxNeg));
            System.out.print(" ");

            //2. 원소가 연속되지 않은 부분배열까지 고려한 최대합
            if(nonContMaxSum > 0)
                System.out.print(nonContMaxSum);
            else
                System.out.print(maxNeg);
            return 0;
        }

        // 카데인 알고리즘
        // https://sustainable-dev.tistory.com/23

        public static int maxSubArrayDP(int[] nums) {
            int[] ans = new int[nums.length];
            ans[0] = nums[0];
            int max = nums[0];
            for (int i=1;i<nums.length;i++){
                ans[i] = (ans[i-1]<0) ? nums[i]:ans[i-1]+nums[i];
                max = (max>ans[i]) ? max:ans[i];
            }
            return max;
        }

        public static int maxSubArrayDp(int[] nums) {
            int[] ans = new int[nums.length];
            ans[0] = nums[0];
            int max = nums[0];
            for(int i : nums) {
                ans[i] = (ans[i-1] < 0)? nums[i]:ans[i-1]+nums[i];
                max = (max>ans[i])? max : ans[i];
            }
            return max;
        }

        public static int maxSubArray3(int[] nums) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for(int i : nums) {
                sum = Math.max(sum + i , i);
                max = Math.max(sum, max);
            }
            return max;
        }
    }
}
