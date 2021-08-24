package leetcode.medium;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        System.out.println(SolutionBinary.searchRange(new int[]{5,7,7,8,8,10,10,11,11,15,15}, 15));
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int first = helper(nums, target, true);
            int second = helper(nums, target, false);

            return new int[]{first, second};
        }

        private int helper(int[] nums, int target, boolean first) {
            int result = -1;
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if(first) {
                    if(nums[mid] == target) {
                        result = mid;
                        end = mid - 1;
                    } else if(nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if(nums[mid] == target) {
                        result = mid;
                        start = mid + 1;
                    } else if(nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return result;
        }
    }

    static class SolutionBinary {
        private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target || (left && target == nums[mid])) {
                    hi = mid;
                }
                else {
                    lo = mid+1;
                }
            }

            return lo;
        }

        public static int[] searchRange(int[] nums, int target) {
            int[] targetRange = {-1, -1};

            int leftIdx = extremeInsertionIndex(nums, target, true);

            if (leftIdx == nums.length || nums[leftIdx] != target) {
                return targetRange;
            }

            targetRange[0] = leftIdx;
            targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

            return targetRange;
        }
    }

    class SolutionEasyToUnderstand {
        public int[] searchRange(int[] nums, int target) {
            int first = helper(nums, target, true);
            int last = helper(nums, target, false);
            int[] result = new int[2];
            result[0] = first;
            result[1] = last;
            return result;
        }

        public int helper(int[] nums, int target, boolean first) {
            int result = -1;
            int start = 0;
            int end = nums.length-1;
            while (start <= end) {
                int mid = start + (end-start)/2;
                if (first) {
                    if (nums[mid] == target) {
                        result = mid;
                        end = mid-1;
                    } else if (nums[mid] > target) {
                        end = mid-1;
                    } else {
                        start = mid+1;
                    }
                } else {
                    if (nums[mid] == target) {
                        result = mid;
                        start = mid+1;
                    } else if (nums[mid] < target) {
                        start = mid+1;
                    } else {
                        end = mid-1;
                    }
                }

            }
            return result;
        }
    }
}
