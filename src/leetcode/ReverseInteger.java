package leetcode;

public class ReverseInteger {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(Solution.reverse(964632435));
    }

    static class Solution {
        public static int reverse(int x) {

            if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
                return 0;
            }
            char[] numChars = String.valueOf(Math.abs(x)).toCharArray();
            int charLength = numChars.length;

            for(int i = 0; i < (charLength/2) ; i++) {
                char temp = numChars[i];
                numChars[i] = numChars[charLength - 1 - i];
                numChars[charLength - 1 - i] = temp;
            }

            int result = Integer.parseInt(String.valueOf(numChars));
            if(x < 0){
                result = -result;
            }

            return result;
        }

        public static int reverseGood(int x) {
            String ans = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
                    : new StringBuilder(String.valueOf(x)).reverse().toString();
            try {
                return Integer.parseInt(ans);
            } catch (Exception e) {
                return 0;
            }
        }

        public static int reverseBest(int x) {
            long res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x = x / 10;
            }

            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int)res;
            }
        }
    }

}



