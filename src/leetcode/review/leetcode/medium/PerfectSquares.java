package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(Solution.numSquares(17));
    }

    static class Solution {
        static List<Integer> result = new ArrayList<>();
        public static int numSquares(int n) {
//            if (result.size() == 0) {
//                result.add(0);
//            }
//            while (result.size() <= n) {
//                int m = result.size();
//                int tempMin = Integer.MAX_VALUE;
//                for (int j = 1; j * j <= m; j++) {
//                    tempMin = Math.min(tempMin, result.get(m - j * j) + 1);
//                }
//                result.add(tempMin);
//            }
//            return result.get(n);
            if(result.size() == 0) {
                result.add(0);
            }
            while (result.size() <= n) {
                int m = result.size();
                int tempMin = Integer.MAX_VALUE;
                for(int i = 1; i * i <= m; i++) {
                    tempMin = Math.min(tempMin, result.get(m - (i * i)) + 1);
                }
                result.add(tempMin);
            }
            return result.get(n);
        }
    }
}
