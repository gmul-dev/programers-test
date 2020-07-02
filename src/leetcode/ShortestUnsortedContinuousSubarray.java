package leetcode;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(Solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    static class Solution {
        public static int findUnsortedSubarray(int[] nums) {
            int numsLength = nums.length;

            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i] > nums[i+1])
                    break;
                else
                    numsLength--;
            }

            for(int i = nums.length - 1; i > 0; i--) {
                if(nums[i] < nums[i-1])
                    break;
                else
                    numsLength--;
            }
            return numsLength;
        }
    }



    public class SolutionBruteForce {
        public int findUnsortedSubarray(int[] nums) {
            int l = nums.length, r = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        r = Math.max(r, j);
                        l = Math.min(l, i);
                    }
                }
            }
            return r - l < 0 ? 0 : r - l + 1;
        }
    }

    public class SolutionBest {
        public int findUnsortedSubarray(int[] nums) {
            int start = 0, end = -1;
            int min = nums[nums.length - 1], max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(nums[i], max);
                min = Math.min(nums[nums.length - i - 1], min);
                if (nums[i] < max) end = i;
                if (nums[nums.length - i - 1] > min) start = nums.length - i - 1;
            }

            return end - start + 1;
        }
    }
}
