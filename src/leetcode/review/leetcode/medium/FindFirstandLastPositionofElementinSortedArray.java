package leetcode.review.leetcode.medium;

public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        System.out.println(Solution.searchRange(new int[]{5,7,7,8,8,10}, 8));
    }

    static class Solution {
        public static int[] searchRange(int[] nums, int target) {
            int[] result = new int[]{-1, -1};
            int idx = 0;

            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == target) {
                    if(idx == 0) {
                        result[idx] = i;
                        result[++idx] = i;
                    } else {
                        result[idx] = i;
                    }
                } else  {
                    if(idx > 0)
                        break;
                }
            }

            return result;
        }
    }
}
