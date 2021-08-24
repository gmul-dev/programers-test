package leetcode.medium;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(Solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }

    static class Solution {

//        public List<List<Integer>> fourSum(int[] nums, int target) {
//            Arrays.sort(nums);
//            return kSum(nums, target, 0, 4);
//        }
//
//        public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
//            List<List<Integer>> result = new ArrayList<>();
//            if (start == nums.length  // end of list
//                    || nums[start] * k > target  // numbers after start are >= number at start
//                    || nums[nums.length - 1] * k < target  // numbers in array are not large enough
//            ) {
//                return result;
//            }
//
//            if (k == 2) {
//                return twoSum(nums, target, start);
//            }
//
//            for (int i = start; i < nums.length; i++) {
//                // ignore duplicates
//                if (i != start && nums[i - 1] == nums[i]) {
//                    continue;
//                }
//
//                for (List<Integer> set: kSum(nums, target - nums[i], i + 1, k - 1)) {
//                    List<Integer> ksum = new ArrayList<>();
//                    ksum.add(nums[i]);
//                    ksum.addAll(set);
//                    result.add(ksum);
//                }
//            }
//
//            return result;
//        }
//
//        public List<List<Integer>> twoSum(int[] nums, int target, int start) {
//            List<List<Integer>> result = new ArrayList<>();
//            int low = start;
//            int high = nums.length - 1;
//            while (low < high) {
//                int sum = nums[low] + nums[high];
//                if (sum < target || (low > start && nums[low] == nums[low - 1])) {
//                    // if sum is too small or number at low is the same as its previous number
//                    low++;
//                } else if (sum > target || (high < nums.length - 1 && nums[high] == nums[high + 1])) {
//                    // if sum is too large or number at high is the same as its nest number
//                    high--;
//                } else {
//                    result.add(Arrays.asList(nums[low], nums[high]));
//                    low++;
//                    high--;
//                }
//            }
//
//            return result;
//        }
//
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            Set<List<Integer>> set = new HashSet<>();
            Arrays.sort(nums);
            for(int i=0;i<nums.length-3;i++){
                for(int j=i+1;j<nums.length-2;j++){
                    int l = j+1;
                    int r = nums.length-1;
                    while(l<r){
                        int sum = nums[i]+nums[j]+nums[l]+nums[r];
                        if(sum == target) {
                            set.add(Arrays.asList(nums[i],nums[j],nums[l++],nums[r--]));
                        }
                        else if(sum>target) r--;
                        else  l++;
                    }
                }
            }
            return new ArrayList<>(set);
        }

    }
}
