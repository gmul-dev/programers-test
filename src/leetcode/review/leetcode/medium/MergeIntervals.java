package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        System.out.println(SolutionBest.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }

    static class Solution {
        public static int[][] merge(int[][] intervals) {
            List<int[]> result = new ArrayList<>();

            int[] starts = new int[intervals.length];
            int[] ends = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                starts[i] = intervals[i][0];
                ends[i] = intervals[i][1];
            }

            Arrays.sort(starts);
            Arrays.sort(ends);

            int start = 0;
            for (int end = 0; end < ends.length; end++) {
                if (end + 1 == ends.length || ends[end] < starts[end + 1]) {
                    result.add(new int[]{starts[start], ends[end]});
                    start = end + 1;
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }

    static class SolutionBest {
        public static int[][] merge(int[][] intervals) {
            int count = intervals.length;
            for (int i = 0; i < intervals.length - 1; i++) {
                int[] s1 = intervals[i];
                for (int j = i + 1; j < intervals.length; j++) {
                    int[] s2 = intervals[j];
                    if (s1[0] <= s2[1] && s2[0] <= s1[1]) {
                        s2[0] = Math.min(s1[0], s2[0]);
                        s2[1] = Math.max(s1[1], s2[1]);
                        s1[0] = -1;
                        count--;
                        break;
                    }
                }
            }
            int[][] ans = new int[count][];
            int index = 0;
            for (int[] itv: intervals) {
                if (itv[0] >= 0) ans[index++] = itv;
            }
            return ans;
        }
    }
}
