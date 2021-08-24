package leetcode.review.leetcode.medium;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(Solution.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    static class Solution {
        public static int search(int[] nums, int target) {
            int l = 0, r = nums.length-1;

            while (l <= r) {
                int mid = (l + r) / 2;
                if(nums[mid] == target) {
                    return mid;
                }

                if(nums[l] <= nums[mid]) {
                    if(target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if(target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
