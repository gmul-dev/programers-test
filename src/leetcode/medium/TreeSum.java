package leetcode.medium;

import java.util.*;

public class TreeSum {
    public static void main(String[] args) {
        System.out.println(Solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    static class Solution {
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;

            for(int i=0; i<n-2; i++){
                if(nums[i] > 0) break;
                if(i > 0 && nums[i] == nums[i - 1]) continue;

                int target = 0 - nums[i];
                int lo = i + 1, hi = n - 1;
                while(lo < hi){
                    int temp = nums[lo] + nums[hi];
                    if(temp == target){
                        res.add(Arrays.asList(new Integer[]{nums[i], nums[lo], nums[hi]}));
                        lo++;
                        while(lo < hi && nums[lo] == nums[lo-1]) lo++;
                        hi--;
                        while(lo < hi && nums[hi] == nums[hi + 1]) hi--;
                    }else if(temp < target){
                        lo++;
                    }else{
                        hi--;
                    }
                }
            }
            return res;
        }
    }
}
