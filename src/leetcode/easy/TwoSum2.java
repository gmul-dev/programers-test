package leetcode.easy;

public class TwoSum2 {

    public static void main(String[] args) {
        SolutionTwoSum2 solution = new SolutionTwoSum2();
        System.out.println(solution.twoSum(new int[]{0,4,3,0}, 0));
    }
}

class SolutionTwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        int sum = nums[lo] + nums[hi];
        while(nums[lo] + nums[hi] != target)
            if (nums[lo] + nums[hi] > target)
                hi--;
            else
                lo++;
        return new int[] {lo+1,hi+1};
    }
}

