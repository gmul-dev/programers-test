package leetcode.review.leetcode.medium;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println(Solution.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

    static class Solution {
        public static int leastInterval(char[] tasks, int n) {
//            int[] f = new int[26];
//            for(char task : tasks)
//                f[task - 'A']++;
//            Arrays.sort(f);
//            int chunk = f[25] - 1;
//            int idleSpots = chunk * n;
//
//            for(int i = 24; i >= 0; i--)
//                idleSpots -= Math.min(chunk, f[i]);
//
//            return idleSpots < 0 ? tasks.length : idleSpots + tasks.length;

//            int[]frequencies=new int[26];
//            for(char ch:tasks){
//                frequencies[ch-'A']++;
//            }
//            Arrays.sort(frequencies);
//            int max= frequencies[25];
//
//            int count=0;
//            for(int i=0;i<frequencies.length;i++){
//                if(frequencies[i]==max)
//                    count++;
//            }
//
//            return Math.max(tasks.length,(max-1)*(n+1)+count);

            int[] ch = new int[26];
            for(char c : tasks) {
                ch[c - 'A']++;
            }
            Arrays.sort(ch);
            int max = ch[25] - 1;
            int idle = max * n;
            for(int i = 24; i >= 0; i--) {
                idle -= Math.min(max, ch[i]);
            }

            return idle > 0? tasks.length + idle : tasks.length;
        }
    }
}
