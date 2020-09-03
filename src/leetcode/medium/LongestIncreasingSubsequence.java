package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(SolutionDPWithBinarySearch.lengthOfLIS(new int[]{10,9,2,5,3,4}));
    }

    static class Solution {
        public static int lengthOfLIS(int[] nums) {

            List<Integer> result = new ArrayList<>();

            for(int i = 0; i < nums.length; i++) {
                if(!result.contains(nums[i])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] > temp.get(temp.size() - 1)) {
                            temp.add(nums[j]);
                        }
                    }
                    if(temp.size() > result.size()) {
                        result = new ArrayList<>(temp);
                    }
                }
            }

            return result.size();
        }
    }

    class SolutionDP {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxans = 1;
            for(int i = 1; i < dp.length; i++) {
                int maxval = 0;
                for(int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]) {
                        maxval = Math.max(maxval, dp[j]);
                    }
                }
                dp[i] = maxval + 1;
                maxans = Math.max(maxans, dp[i]);
            }
            return maxans;
        }
    }

    static class SolutionDPWithBinarySearch {
        public static int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for(int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if(i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if(i == len) {
                    len++;
                }
            }
            return len;
        }
    }

    class SolutionRecusiveWithMemoization {
        public int lengthOfLIS(int[] nums) {
            int memo[][] = new int[nums.length + 1][nums.length];

            for(int[] l : memo) {
                Arrays.fill(l, -1);
            }
            return lengthOfLIS(nums, -1, 0, memo);
        }

        public int lengthOfLIS(int[] nums, int prevIndex, int curpos, int[][] memo) {
            if(curpos == nums.length) {
                return 0;
            }

            if(memo[prevIndex + 1][curpos] >= 0) {
                return memo[prevIndex + 1][curpos];
            }

            int taken = 0;
            if(prevIndex < 0 || nums[curpos] > nums[prevIndex]) {
                taken = 1 + lengthOfLIS(nums, curpos, curpos+1, memo);
            }
            int nottaken = lengthOfLIS(nums, prevIndex, curpos+1, memo);

            memo[prevIndex + 1][curpos] = Math.max(taken, nottaken);

            return memo[prevIndex + 1][curpos];
        }
    }
}
