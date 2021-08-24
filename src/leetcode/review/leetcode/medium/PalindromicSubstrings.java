package leetcode.review.leetcode.medium;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(Solution.countSubstrings("aabbcc"));
    }

    static class Solution {
        public static int countSubstrings(String s) {
            int result = 0;
            char[] ch = s.toCharArray();
            for(int i = 0; i < s.length(); i++) {
                result += count(ch, i, i); // odd palindrom
                result += count(ch, i, i+1); // even palindrom
            }
            return result;
        }

        private static int count(char[] ch, int left, int right) {
            int count = 0;

            while (left >= 0 && right < ch.length) {
                if(ch[left] == ch[right]) {
                    count++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            return count;
        }

    }

//    class MySolution {
//        public int countSubstrings(String s) {
//
//        }
//
//        private void helper(String s, int idx, String pal, int count) {
//            if(idx == s.length() - 1) {
//                return;
//            }
//
//            for(int i = idx; i < s.length(); i++) {
//                helper(s, idx++, pal, count++);
//
//                String k = pal + s.charAt(i);
//                if(!k.equals("") && findPalindrome()) {
//                    helper(s, idx++, pal, count++);
//                }
//            }
//        }
//    }
}
