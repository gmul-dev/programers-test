package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/

// no sort, duplicate, no reusable value
//Input: candidates = [2,5,2,1,2], target = 5,
//    A solution set is:
//    [
//        [1,2,2],
//        [5]
//    ]
public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(Solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    static class Solution {
        public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<Integer> candidateSum = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(candidates);

            combinationSum2(candidates, 0, target, candidateSum, result);

            return result;
        }

        private static void combinationSum2(int[] candidates, int index, int target, List<Integer> candidateSum, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<>(candidateSum));
                return;
            }

            for (int i=index; i<candidates.length; i++) {
                if (i > index && (candidates[i-1] == candidates[i])) {
                    continue;
                }

                int element = candidates[i];
                if (target-element < 0) {
                    break;
                }

                candidateSum.add(element);
                combinationSum2(candidates, i+1, target - element, candidateSum, result);
                candidateSum.remove(candidateSum.size()-1);
            }
        }
    }
}
