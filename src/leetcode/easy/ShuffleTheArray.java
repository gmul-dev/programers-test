package leetcode.easy;

public class ShuffleTheArray {
    public static void main(String[] args) {
        System.out.println(Solution.shuffle(new int[]{1,2,3,4,5,6,7,8},4));
    }

    static class Solution {
        public static int[] shuffle(int[] nums, int n) {
            int[] result = new int[2*n];
            for(int i = 0; i < n; i++) {
                result[2*i] = nums[i];
                result[2*i+1] = nums[n+i];
            }
            return result;
        }
    }
}
