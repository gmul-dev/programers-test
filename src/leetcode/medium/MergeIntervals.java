package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] params = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Solution.merge(params));
    }

    static class Solution {
        public static int[][] merge(int[][] intervals) {
            if(intervals.length == 0) return new int[][]{};

            //sort가 빠졌다.....
            Arrays.sort(intervals,(i1, i2)->(i1[0]-i2[0]));

            List<int[]> resultList = new ArrayList<>();
            int i = 1;
            int[] current = intervals[0];
            while (i < intervals.length) {
                if(current[1] >= intervals[i][0]) {
                    current[1] = Math.max(current[1], intervals[i][1]);
                }  else {
                    resultList.add(current);
                    current = intervals[i];
                }
                i++;
            }
            resultList.add(current);

            int[][] result = new int[resultList.size()][2];
            resultList.toArray(result);

            return result;
        }
    }

    class SolutionBest {
        public int[][] merge(int[][] intervals) {
            int count = intervals.length;
            for(int i = 0; i < intervals.length - 1; ++i) {
                int[] i1 = intervals[i];
                for(int j = i + 1; j < intervals.length; ++j) {
                    int[] i2 = intervals[j];
                    if(i1[0] <= i2[1] && i1[1] >= i2[0]) {
                        i2[0] = Math.min(i1[0], i2[0]);
                        i2[1] = Math.max(i1[1], i2[1]);
                        i1[0] = 1;
                        i1[1] = 0;
                        --count;
                        break;
                    }
                }
            }
            int[][] ans = new int[count][];
            for(int i = 0, j = 0; i < intervals.length; ++i) {
                if(intervals[i][0] <= intervals[i][1]) {
                    ans[j++] = intervals[i];
                }
            }
            return ans;
        }
    }

    class SolutionSort {
        public int[][] merge(int[][] intervals) {
            if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
                return intervals;

            Arrays.sort(intervals,(i1, i2)->(i1[0]-i2[0]));

            int start = 0;
            int index = 1;

            for(;index<intervals.length;index++){
                int[] first = intervals[start];
                int[] next = intervals[index];

                if(first[1] >= next[0]){
                    intervals[start][1] = Math.max(first[1],next[1]);
                } else{
                    start++;
                    intervals[start] = intervals[index];
                }
            }

            int[][] res = new int[start+1][2];
            for(index=0;index<res.length;index++){
                res[index] = intervals[index];
            }

            return res;
        }
    }
}
