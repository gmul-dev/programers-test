package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(SolutionDFS.permute(new int[]{1,2,3}));
    }

    static class SolutionDFS {
        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (null == nums || 0 == nums.length) {
                result.add(new ArrayList<>());
                return result;
            }

            helper(nums, 0, result);
            return result;
        }

        private static void helper(int[] nums, int pos, List<List<Integer>> result) {
            if (pos == nums.length) {
                List<Integer> list = new ArrayList<>();
                for (int x : nums)
                    list.add(x);
                result.add(list);
            }

            for (int i = pos; i < nums.length; ++i) {
                swap(nums, i, pos);
                helper(nums, pos + 1, result);
                swap(nums, i, pos);
            }
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
