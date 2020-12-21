package leetcode.review.leetcode.medium;

public class SortColors {
    public static void main(String[] args) {
        Solution.sortColors(new int[]{2,0,2,1,1,0});
    }

    static class Solution {
        public static void sortColors(int[] nums) {
            int start = 0;
            int end = nums.length - 1;

            int index = start;

            while(index <= end) {
                if(nums[index] == 0) {
                    int temp = nums[start];
                    nums[start] = nums[index];
                    nums[index] = temp;
                    start++;
                    index++;
                } else if(nums[index] == 1) {
                    index++;
                } else {
                    int temp = nums[index];
                    nums[index] = nums[end];
                    nums[end] = temp;
                    end--;
                }
            }
        }
    }
}
