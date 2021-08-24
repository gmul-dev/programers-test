package leetcode.review.leetcode.medium;

public class CountingBits {

    public static void main(String[] args) {
        System.out.println(Solution.countBits(5));
    }

    static class Solution {
        public static int[] countBits(int num) {
//            int[] count = new int[num+1];
//
//            for(int i = 1; i <= num; i++) {
//                count[i] = Integer.toBinaryString(i).replace("0", "").length();
//            }
//
//            return count;

            if(num == 0)
                return new int[] {0};
            if(num == 1)
                return new int[] {0,1};

            int[] arr = new int[num+1];
            arr[0] = 0;
            arr[1] = 1;

            for(int i = 2; i <= num; i++) {
                if(i % 2 == 0)
                    arr[i] = arr[i/2];
                else
                    arr[i] = arr[i/2]+1;
            }

            return arr;
        }
    }
}
