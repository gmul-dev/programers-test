package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(Solution.combinationSum(new int[]{1,3,2,5}, 5));
    }

    static class Solution {
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            helper(candidates, target, 0, new ArrayList<>(), result);
            return result;
        }

        private static void helper(int[] condidates, int target, int idx, List<Integer> list, List<List<Integer>> result) {

            if(target == 0) {
                result.add(new ArrayList<>(list));
                return;
            }

            for(int i = idx; i < condidates.length; i++) {
                if(target - condidates[i] >= 0) {
                    list.add(condidates[i]);
                    helper(condidates, target - condidates[i], i, list, result);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
