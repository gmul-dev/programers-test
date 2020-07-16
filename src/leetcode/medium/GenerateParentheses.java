package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(Solution.generateParenthesis(3));
    }

    static class Solution {
        public static List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            backtrack(res, new StringBuilder(), n, 0, 0);
            return res;
        }

        private static void backtrack(List<String> res, StringBuilder sb, int n, int open, int closed) {
            if(sb.length() == 2*n) {
                res.add(sb.toString());
                return;
            }

            if(open < n) {
                sb.append('(');
                backtrack(res, sb, n, open + 1, closed);
                sb.setLength(sb.length() - 1);
            }

            if(closed < open) {
                sb.append(')');
                backtrack(res,sb, n, open, closed + 1);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
