package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        SolutionSubSet solutionSubSet = new SolutionSubSet();
        System.out.println(solutionSubSet.subsetsWithDup(new int[]{1,2,2}));
    }
}

class SolutionSubSet {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void helper(int index, int[] nums, ArrayList<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        for(int i = index; i < nums.length; ++i) {
            if(i > index && nums[i-1] == nums[i]) continue;
            curr.add(nums[i]);
            helper(i + 1, nums, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
