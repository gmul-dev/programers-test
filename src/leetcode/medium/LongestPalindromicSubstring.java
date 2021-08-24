package leetcode.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("aseess"));
    }
}

class Solution {
    int starti = 0;
    int endi = 0;
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        while (i < c.length) {
            i = search(i, c);
        }

        return s.substring(starti, endi);
    }

    public int search(int i, char[] c) {
        int s = i + 1;
        while (s < c.length && c[i] == c[s]) {
            s++;
        }

        int end = s;
        int ss = i - 1;

        while (ss >= 0 && end < c.length && c[ss] == c[end]) {
            ss --;
            end ++;
        }

        if (endi - starti < end - ss - 1) {
            endi = end;
            starti = ss + 1;
        }

        return  s;
    }
}
