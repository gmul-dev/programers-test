package leetcode.review.leetcode.medium;

import java.util.Arrays;

public class KthLargestElementinanArray {

    public static void main(String[] args) {
        System.out.println(Solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    static class Solution {

        private static void quickSort(int[] nums, int start, int end, int k) {
            int left = start;
            int right = end;
            int pivot = nums[(end - start) / 2 + start];
            while (right >= left) {
                while (right >= left && nums[left] > pivot) ++left;
                while (right >= left && nums[right] < pivot) --right;
                if (right >= left) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    ++left;
                    --right;
                }
            }
            if (k <= right) quickSort(nums, start, right, k);
            if (k >= left) quickSort(nums, left, end, k);

            // if (right > start) quickSort(nums, start, right, k);
            // if (left < end) quickSort(nums, left, end, k);
        }

        public static int findKthLargest(int[] nums, int k) {
            quickSort(nums, 0, nums.length - 1, k-1);
            return nums[k - 1];
        }
    }

    static class MySolution {
        public static int findKthLargest(int[] nums, int k) {

            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
}
