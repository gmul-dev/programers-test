package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        System.out.println(Solution1.letterCombinations("23"));
    }

    static class Solution1 {
        public static List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return new ArrayList<>();

            String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            List<String> res = new ArrayList<>();
            letterCombinationsHelper(phone, digits, 0, res, new StringBuilder());

            return res;
        }

        private static void letterCombinationsHelper(String[] phone, String digits, int idx, List<String> res, StringBuilder sb) {
            if (idx == digits.length()) {
                res.add(sb.toString());
                return;
            }

            String word = phone[digits.charAt(idx) - '0'];
            for (int i = 0; i < word.length(); ++i) {
                sb.append(word.charAt(i));
                letterCombinationsHelper(phone, digits, idx + 1, res, sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
