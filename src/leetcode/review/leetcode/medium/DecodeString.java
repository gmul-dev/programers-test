package leetcode.review.leetcode.medium;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(Solution.decodeString("3[a2[c]]"));
    }

    static class Solution {
        public static String decodeString(String s) {

            int length = s.length();
            int idx = 0;
            int sum = 0;
            StringBuilder sb = new StringBuilder();

            while (idx < length) {
                char ch = s.charAt(idx);
                if(Character.isDigit(ch)) {
                    sum = sum * 10 + (ch - '0');
                } else if(ch - 'a' >= 0 && ch - 'a' <= 25) {
                    sb.append(ch);
                } else {
                    int last = idx+1, l = 1;
                    while (l > 0) {
                        char c1 = s.charAt(last);
                        if(c1 == '['){
                            l ++;
                        }else if(c1 == ']'){
                            l --;
                        }
                        last ++;
                    }
                    String str = decodeString(s.substring(idx+1, last-1));
                    idx = last - 1;
                    sum = sum == 0? 1 : sum;
                    while (sum-- > 0) {
                        sb.append(str);
                    }
                    sum = 0;
                }
                idx++;
            }
            return sb.toString();
        }
    }
}
