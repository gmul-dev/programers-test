package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(Solution.generateParenthesis(5));
    }

    static class Solution {
        public static List<String> generateParenthesis(int n) {
            char[] ch = new char[n*2];
            List<String> result = new ArrayList<>();
            helper(n, 0, 0, ch, result);
            return result;
        }

        private static void helper(int n, int open, int index, char[] ch, List<String> result) {
            if(n < 0 || open < 0)
                return;
            if(index == ch.length) {
                if(open != 0) {
                    return;
                }
                result.add(String.valueOf(ch));
                return;
            }

            ch[index] = '(';
            helper(n-1, open+1, index+1, ch, result);
            ch[index] = ')';
            helper(n, open-1, index+1, ch, result);
        }
    }

    static class SolutionSimple {
        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generateParenthesis(n, n, result, "");
            return result;
        }

        public static void generateParenthesis(int open, int close, List<String> result, String comb) {
            if (open == 0 && close == 0) {
                result.add(comb);
                return;
            }
            if (open > 0) {
                generateParenthesis(open-1, close, result, comb+"(");
            }
            if (open < close) {
                generateParenthesis(open, close-1, result, comb+")");
            }
        }
    }
}
