package leetcode.medium;

public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(SolutionBest.findDuplicate(new int[]{1,3,4,2,2}));
    }

//    You must not modify the array (assume the array is read only).
//    You must use only constant, O(1) extra space.
//    Your runtime complexity should be less than O(n2).
//    There is only one duplicate number in the array, but it could be repeated more than once.
    static class Solution {
        public static int findDuplicate(int[] nums) {
            if(nums.length == 0 || nums.length == 1)
                return 0;

            if(nums.length == 2)
                return nums[0];

            for(int i = 0; i < nums.length; i++) {
                for(int j = nums.length - 1; j > i; j--) {
                    if(nums[i] == nums[j]) {
                        return nums[i];
                    }
                }
            }

            return 0;
        }
    }

    //Floyd's Tortoise and Hare (Cycle Detection)
    static class SolutionBest {
        public static int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[0];

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            slow = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }

    class SolutionGood {
        public int findDuplicate(int[] nums) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[Math.abs(nums[i])] > 0) {
                    nums[Math.abs(nums[i])] *= 1;
                } else {
                    return Math.abs(nums[i]);
                }
            }
            return -1;
        }
    }
}
