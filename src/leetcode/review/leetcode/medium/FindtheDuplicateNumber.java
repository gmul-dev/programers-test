package leetcode.review.leetcode.medium;

public class FindtheDuplicateNumber {

    public static void main(String[] args) {
        System.out.println(Solution.findDuplicate(new int[]{2,3,4,1,3}));
    }

    static class Solution {
        public static int findDuplicate(int[] nums) {
            // Floyd's tortoise and hare
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

            return fast;
        }
//        public int findDuplicate(int[] nums) {
//            Arrays.sort(nums);
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i] == nums[i-1]) {
//                    return nums[i];
//                }
//            }
//
//            return -1;
//        }

//        public int findDuplicate(int[] nums) {
//            Set<Integer> seen = new HashSet<Integer>();
//            for (int num : nums) {
//                if (seen.contains(num)) {
//                    return num;
//                }
//                seen.add(num);
//            }
//
//            return -1;
//        }
    }
}
