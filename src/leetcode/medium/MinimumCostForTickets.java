package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        System.out.println(SolutionDayVariant.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    }

    static class SolutionDayVariant {

        public static int mincostTickets(int[] days, int[] costs) {
            int lastDay = days[days.length - 1];
            boolean[] travel = new boolean[lastDay + 1];
            int[] dp = new int[lastDay + 1];
            for (int day : days) {
                travel[day] = true;
            }
            dp[0] = 0;
            for (int i = 1; i <= lastDay; ++i) {
                if (travel[i]) {
                    int min = dp[i - 1] + costs[0];
                    min = Math.min(min, (i < 7 ? 0 : dp[i - 7]) + costs[1]);
                    min = Math.min(min, (i < 30 ? 0 : dp[i - 30]) + costs[2]);
                    dp[i] = min;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[lastDay];
        }
    }

    class SolutionWindowVariant {
        int[] days, costs;
        Integer[] memo;
        int[] durations = new int[]{1, 7, 30};

        public int mincostTickets(int[] days, int[] costs) {
            this.days = days;
            this.costs = costs;
            memo = new Integer[days.length];

            return dp(0);
        }

        public int dp(int i) {
            if (i >= days.length)
                return 0;
            if (memo[i] != null)
                return memo[i];

            int ans = Integer.MAX_VALUE;
            int j = i;
            for (int k = 0; k < 3; ++k) {
                while (j < days.length && days[j] < days[i] + durations[k])
                    j++;
                ans = Math.min(ans, dp(j) + costs[k]);
            }

            memo[i] = ans;
            return ans;
        }
    }
}
