package leetcode.medium;

public class CountingBits {

    public static void main(String[] args) {
        System.out.println(SolutionBit.countBits(18));
    }

    static class SolutionBit {
        public static int[] countBits(int num) {
            int dp[] = new int[num + 1];
            int pow = 1;
            for(int i = 1, t = 0; i <= num; i++, t++) {
                if (i == pow) {
                    pow = pow << 1;
                    t = 0;
                }
                dp[i] = dp[t] + 1;
            }
            return dp;
        }
    }

    class Solution {
        public int[] countBits(int num) {
            int[] dp = new int[num+1];
            for(int i = 0; i <= num; i++) {
                dp[i] = i%2 + dp[i/2];
            }
            return dp;
        }
    }
}
