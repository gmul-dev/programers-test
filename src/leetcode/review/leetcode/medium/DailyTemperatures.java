package leetcode.review.leetcode.medium;

public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    static class Solution {
        public static int[] dailyTemperatures(int[] T) {
            int ans[] = new int[T.length];

            for (int i= T.length-1; i>=0; i--){
                for (int j= i-1; j>=0; j--){
                    if (T[j]<T[i]) ans[j] = i-j;
                    else break;
                }
            }
            return ans;
        }
    }
}
