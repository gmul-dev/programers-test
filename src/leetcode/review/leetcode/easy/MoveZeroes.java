package leetcode.review.leetcode.easy;

public class MoveZeroes {

    public static void main(String[] args) {
        Solution.moveZeroes(new int[]{0,1,0,3,12});
        System.out.println();
    }

    static class Solution {
        public static void moveZeroes(int[] nums) {
            int j = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    nums[j] = nums[i];
                    j++;
                }
            }
            while (j < nums.length) {
                nums[j] = 0;
                j++;
            }
        }
    }

}
