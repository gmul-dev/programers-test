package leetcode.medium;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        SolutionPartitionEqualSubsetSum solution = new SolutionPartitionEqualSubsetSum();
        System.out.println(solution.canPartition(new int[]{1,5,11,5}));
    }
}

class SolutionPartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) sum += num;

        if (sum % 2 != 0) {
            return false;
        }

        return helper(nums, nums.length, sum/2);
    }
    public boolean helper(int[] nums, int index, int half) {
        if(half == 0)
            return true;
        if(index == 0)
            return false;
        if(nums[index - 1] <= half)
            return helper(nums, index - 1, half - nums[index - 1]) || helper(nums, index - 1, half);
        else
            return false;
    }

}

class SolutionDP {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return false;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        boolean dp[] = new boolean[subSetSum + 1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }
        return dp[subSetSum];
    }
}
