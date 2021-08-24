package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/

// sort, no duplicate, reusable value
//Input: candidates = [2,3,5], target = 8,
//    A solution set is:
//    [
//        [2,2,2,2],
//        [2,3,3],
//        [3,5]
//    ]
public class CombinationSum {
    public static void main(String[] args) {
        SolutionCombinationSum solution = new SolutionCombinationSum();
        System.out.println(solution.combinationSum(new int[]{1,2,2,2,5}, 5));
    }
}

class SolutionCombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void helper(int[] candidates, int index, int remaining, ArrayList<Integer> current, List<List<Integer>> result) {
        if(remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] > remaining) continue;
            current.add(candidates[index]);
            helper(candidates, i, remaining - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
