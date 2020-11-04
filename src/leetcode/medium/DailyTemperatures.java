package leetcode.medium;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Solution.dailyTemperatures(new int[]{55,38,53,81,61,93,97,32,43,78}));
    }

    static class Solution {
        public static int[] dailyTemperatures(int[] T) {
            int[] dp = new int[T.length];

            for(int i = T.length - 1; i >= 0; i--) {
                if(i == T.length - 1) {
                    dp[i] = 0;
                } else {
                    if(T[i] < T[i + 1]) {
                        dp[i] = 1;
                    } else {
                        int count = dp[i + 1] + 1;
                        while (i + count < T.length && T[i] < T[i + count] && dp[i + count] > 0) {
                            count += dp[i + count];
                        }
                        if(i + count >= T.length || (T[i] >= T[i + count] && dp[i + count] == 0)) {
                            dp[i] = 0;
                        } else {
                            dp[i] = count;
                        }
                    }
                }
            }
            return dp;
        }

//        public static int[] dailyTemperatures(int[] T) {
//            int[] stack = new int[T.length];
//            int top = -1;
//            int[] res = new int[T.length];
//
//            for(int i=0;i<T.length;i++){
//                while(top>-1 && T[stack[top]]<T[i]){
//                    int idx = stack[top--];
//                    res[idx] = i-idx;
//                }
//                stack[++top] = i;
//            }
//            return res;
//        }


//        public static int[] dailyTemperatures(int[] T) {
//            int[] result = new int[T.length];
//
//            for(int i = 0; i < T.length - 1; i++) {
//                int cnt = 0;
//                for(int j = i + 1; j < T.length; j++) {
//                    cnt++;
//                    if(T[i] < T[j]) {
//                        result[i] = cnt;
//                        break;
//                    }
//                }
//            }
//            return result;
//        }
    }
}
