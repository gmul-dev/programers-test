package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(Solution1.majorityElement(new int[]{2,2,3,3,4,3,3}));
    }

    public static class Solution {
        public static int majorityElement(int[] nums) {
            if(nums.length == 1) return nums[0];
            int half = nums.length/2;
            int maxNum = 0;
            Map<Integer, Integer> countMap = new HashMap<>();

            for(int num : nums) {
                if(countMap.containsKey(num)) {
                    int count = countMap.get(num) + 1;
                    if(count > half) maxNum = num;
                    countMap.put(num, count);
                } else {
                    countMap.put(num, 1);
                }
            }

            return maxNum;
        }
    }

    public static class Solution1 {
        public static int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            return candidate;
        }
    }

    public static class Solution2 {
        public static int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    public static class Solution3 {
        public int majorityElement(int[] nums) {
            return findMajorityElementFromStartIdx(nums, 0);
        }

        private int findMajorityElementFromStartIdx(int[] nums, int startIdx) {
            int pivot = nums[startIdx];
            int cnt = 1;
            for (int i = startIdx + 1; i < nums.length; i++) {
                if (nums[i] == pivot) {
                    cnt++;
                } else {
                    cnt--;
                }
                if (cnt == 0) {
                    return findMajorityElementFromStartIdx(nums, i + 1);
                }
            }
            return pivot;
        }
    }
}
