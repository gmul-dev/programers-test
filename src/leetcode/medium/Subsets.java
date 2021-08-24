package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(Solution.subsets(new int[]{1,2,3,4,5}));
    }

    static class Solution {
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            getSubsets(new ArrayList<Integer>(), 0, nums, result);
            return result;
        }
        public static void getSubsets(List<Integer> currList, int start, int[] nums, List<List<Integer>> result){
            result.add(new ArrayList<Integer>(currList));
            for(int i = start; i < nums.length; i++){
                currList.add(nums[i]);
                getSubsets(currList, i+1, nums, result);
                currList.remove(currList.size()-1);
            }
        }
    }

    class SolutionBackTracking{
        List<List<Integer>> output = new ArrayList();
        int n, k;

        public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {

            if (curr.size() == k){
                output.add(new ArrayList(curr));
                return;
            }

            for (int i = first; i < n; ++i) {
                curr.add(nums[i]);
                backtrack(i + 1, curr, nums);
                curr.remove(curr.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            for (k = 0; k < n + 1; ++k) {
                backtrack(0, new ArrayList<Integer>(), nums);
            }
            return output;
        }
    }
}
