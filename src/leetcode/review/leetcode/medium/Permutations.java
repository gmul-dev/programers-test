package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(Solution.permute(new int[]{1,2,3}));
    }

    static class Solution {
        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            System.out.println(res);

            List<Integer> permutations = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            helper(nums,permutations,used,res);
            return res;
        }

        private static void helper(int[] nums, List<Integer> permutations, boolean[] used, List<List<Integer>> res){
            if (permutations.size() == nums.length){
                res.add(new ArrayList<Integer>(permutations));
                return;
            }

            for (int i = 0; i<nums.length; ++i){
                if(used[i]){
                    continue;
                }
                //System.out.println(res);
                used[i] = true;

                permutations.add(nums[i]);
                helper(nums,permutations,used,res);
                permutations.remove(permutations.size()-1);
                used[i] = false;
            }
        }
    }
}
