package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {

    public static void main(String[] args) {
        System.out.println(Solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    static class Solution {
        public static int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(k);
            for (int n : nums) {
                queue.add(n);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            return queue.poll();
        }
    }

    class SolutionBest {
        public int findKthLargest(int[] nums, int k) {
            return dfs(nums, k, 0, nums.length - 1);
        }
        private int dfs(int[] nums, int k, int start, int end) {
            if (start == end) {
                return nums[start];
            }
            int pivot = nums[(start + end) / 2];
            int left = start, right = end;
            while (start <= end) {
                while (start <= end && nums[start] > pivot) {
                    start++;
                }
                while (start <= end && nums[end] < pivot) {
                    end--;
                }
                if (start <= end) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }
            }
            if (left + k - 1 <= end) {
                return dfs(nums, k, left, end);
            }
            if (left + k - 1 >= start) {
                return dfs(nums, k - start + left, start, right);
            }
            return nums[start - 1];
        }
    }
}
