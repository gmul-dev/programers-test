package leetcode.medium;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(Solution.countSubstrings("aaaa"));
    }

    static class Solution {

//        public static int countSubstrings(String s) {
//           char[] cs = s.toCharArray();
//           int count = 0;
//           for(int i = 0; i < s.length(); i++) {
//               count += getPalinSub(cs, i, i);
//               count += getPalinSub(cs, i, i + 1);
//           }
//           return count;
//        }
//
//        private static int getPalinSub(char[] cs, int i, int j) {
//            int cnt = 0;
//            while (i >= 0 && j < cs.length && cs[i--] == cs[j++]) {
//                cnt++;
//            }
//            return cnt;
//        }

        public static int countSubstrings(String s) {
            int count = 0;

            for(int i = 0; i < s.length(); i++){
                int t1 = helper(s, i, i);
                int t2 = helper(s, i, i + 1);

                if(t1 > 1) {
                    count += t1/2;
                }
                if(t2 > 0){
                    count += t2/2;
                }
            }
            return count + s.length();
        }

        private static int helper(String s, int i, int j){
            int l = i;
            int r = j;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            return r - l - 1;
        }

        //  Compares the value of two nodes prev and next. If they are equal, increment count and call the prev and next of
        //  same.
        //        ? <- 0 -> ?
        //      ? <- 0 0 0 -> ?
        //  If case 3 passes, it will also call case 2 on it's outer two nodes.
        //
        //        ? <- 0 0 -> ?
        //      ? <- 0 0 0 0 -> ?
    }
}
