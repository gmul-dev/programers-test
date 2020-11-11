package leetcode.review;

import java.util.Arrays;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(Solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    static class Solution {
        public static int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
