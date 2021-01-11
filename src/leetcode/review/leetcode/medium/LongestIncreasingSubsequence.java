package leetcode.review.leetcode.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLIS(new int[]{10,9,2,5,3,4}));
    }

    static class Solution {
        public static int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] A = new int[n];
            int len=0;
            for(int num : nums){
                int i = Arrays.binarySearch(A,0,len,num);
                if(i<0) i = -(i+1);
                A[i]=num;
                if(len==i) len++;
            }
            return len;
        }
    }
}
