package leetcode.medium;

public class TaskScheduler {

    public static void main(String[] args) {

        System.out.println(Solution.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

    static class Solution {
        public static int leastInterval(char[] tasks, int k) {
            int mxLen = 0, cnt = 0, n = tasks.length;
            int[] cnts = new int[128];
            for (char c : tasks) cnts[c]++;
            for (char c = 'A'; c <= 'Z'; c++) {
                if (cnts[c] > mxLen) {
                    mxLen = cnts[c];
                    cnt = 1;
                } else if (cnts[c] == mxLen) cnt++;
            }
            int secLen = k + 1;
            if (secLen <= cnt) return n;
            int extraSlots = (secLen - cnt) * (mxLen - 1);
            int availSlots = n - (cnt * mxLen);
            return n + Math.max(0, extraSlots - availSlots);
        }
    }
}
