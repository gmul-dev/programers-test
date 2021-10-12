package leetcode.medium;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence s = new LongestConsecutiveSequence();
        System.out.println(s.longestConsecutive(new int[]{1,2,0,1}));
    }

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        return getLongestConsecutive(nums, 0, 1);
    }

    private int getLongestConsecutive(int[] nums, int from, int longest) {
        for(int i = from; i < nums.length - 1; i++) {
            if(nums[i] + 1 == nums[i+1]) {
                longest++;
            }else if(nums[i] != nums[i+1]){
                return Math.max(longest, getLongestConsecutive(nums, i + 1, 1));
            }
        }
        return longest;
    }

//    public int longestConsecutive(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//
//        Arrays.sort(nums);
//
//        int count = 1;
//        int max = 1;
//        for(int i = 1; i < nums.length; i++) {
//            if(nums[i] - nums[i-1] == 1) {
//                count++;
//            } else if(nums[i] - nums[i-1] > 1) {
//                max = Math.max(count, max);
//                count = 1;
//            }
//        }
//        return (max > count)? max : count;
//    }

//    public int longestConsecutive(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//
//        for(int i : nums) {
//            q.add(i);
//        }
//
//        int max = 1;
//        int count = 1;
//        int prev = q.poll();
//        while ( ! q.isEmpty()) {
//            int num = q.poll();
//            if(num == prev + 1) {
//                count++;
//                max = Math.max(max, count);
//            } else if (num == prev) {
//                continue;
//            } else {
//                count = 1;
//            }
//            prev = num;
//        }
//
//        return max;
//    }
}
