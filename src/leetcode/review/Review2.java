package leetcode.review;

//LongestPalindromicSubstring
public class Review2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("aseess"));
    }

    static class Solution {

        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return "";
            int[] arr = new int[2];
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                i = findLPSBasedI(chars, i, arr);
            }
            return s.substring(arr[0], arr[1]+1);
        }
        private int findLPSBasedI(char[] chars, int low, int[] arr) {
            int high = low;
            while (high < chars.length-1 && (chars[high+1] == chars[low])) {
                high++;
            }
            int ans = high;
            while (low > 0 && high < chars.length-1 && (chars[low-1] == chars[high+1])) {
                low--;
                high++;
            }
            if (arr[1]-arr[0] < high-low) {
                arr[0] = low;
                arr[1] = high;
            }
            return ans;
        }
    }
}
