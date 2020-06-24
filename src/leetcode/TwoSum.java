package leetcode;

import java.util.*;

/**
 *  정수로 이루어진 array가 주어졌을 때, 두 숫자의 index의 합이 target과 같은 경우의 index array를 리턴하는 function을 구하세요.
 */

public class TwoSum {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.twoSum(new int[]{0,4,3,0}, 0));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;
        int[] resultArray = new int[2];
        List<Integer> numList = new ArrayList<>();

        for(int num : nums) numList.add(num);

        Arrays.sort(nums);

        for(int i = 0; i < numsLength; i++) {
            for(int j = i; j < numsLength; j++) {
                if(target == (nums[i] + nums[j])) {
                    resultArray[0] = numList.indexOf(nums[i]);
                    resultArray[1] = numList.lastIndexOf(nums[j]);
                }
            }
        }

        return resultArray;
    }

    public int[] twoSumUsingMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumBest(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

