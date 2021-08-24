package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        System.out.println(Solution.letterCombinations("23"));
    }

    static class Solution {
        static char[][] chars = new char[][] {
                {}, {'a', 'b', 'c'}, {'d','e','f'},
                {'g', 'h', 'i'}, {'j','k','l'}, {'m','n','o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };

        public static List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if(digits.length() == 0)
                return result;

            helper(digits, new StringBuffer(), 0, digits.length(), result);
            return result;
        }

        private static void helper(String digits, StringBuffer str, int idx, int length, List<String> result) {
            if(idx == length) {
                result.add(str.toString());
                return;
            }
            int num = digits.charAt(idx) - '0' - 1;
            char[] ch = chars[num];
            for(int i = 0; i < ch.length; i++) {
                str.append(ch[i]);
                idx++;
                helper(digits, str, idx, length, result);
                idx--;
                str.deleteCharAt(str.length()-1);
            }
        }
    }
}
