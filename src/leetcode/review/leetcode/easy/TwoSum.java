package leetcode.review.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Solution.twoSum(new int[]{2,7,11,15}, 9));
    }

    static class Solution {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for(int i = 0; i < nums.length; i++) {
                int index = map.getOrDefault(target - nums[i], -1);
                if(index > -1 && index != i) {
                    return new int[] {i, index};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }

        public static int[] twoSum1(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0;i<nums.length;i++){
                if (map.containsKey(target - nums[i])){
                    return new int[]{i, map.get(target- nums[i])};
                }
                map.put(nums[i],i);
            }
            return new int[]{0,0};
        }
    }
}
