package leetcode.medium;

import java.util.Arrays;

public class TaskScheduler {

    public static void main(String[] args) {

        System.out.println(Solution.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

    static class Solution {
        public static int leastInterval(char[] tasks, int n) {
            int[] count = new int[26];
            for(char c : tasks) {
                count[c - 'A']++;
            }
            Arrays.sort(count);
            int max = count[25] - 1;
            int idle = max * n;
            for(int i = 24; i >= 0; i--) {
                idle = idle - Math.min(max, count[i]);
            }
            return (idle < 0)? tasks.length : idle + tasks.length;
        }
    }
}
