package leetcode.medium;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(Solution.numTrees(3));
    }

    static class Solution {
        public static int numTrees(int n) {

            // https://jjycjnmath.tistory.com/139
            //simply the catalan number of n which is 2n C n/(n+1)
            int k=2*n;
            long res=1l;
            // 2n C n equals [2n*(2n-1)*---*(2n-n+1)] / [n*(n-1)*---*1]
            // here k is 2n
            for(int i=0;i<n;i++){
                res*=(k-i);
                res/=(i+1);
            }
            return (int)(res/(n+1));
        }
    }

    class SolutionDP {

        public int[] memo;

        public int numTrees(int n) {
            memo = new int[n];
            return numTrees(n, 0, n);
        }

        public int numTrees(int n, int l, int r) {

            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 1;
            }

            if (memo[n - 1] > 0) {
                return memo[n - 1];
            }

            int count = 0;
            for (int i = l; i < r; i++) {
                // root is i
                count += numTrees(i - l, l, i) * numTrees(r - i - 1, i + 1, r);
            }

            memo[n - 1] = count;
            return count;
        }
    }
}
