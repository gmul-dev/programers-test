package leetcode.review.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(Solution.isValid("()"));
    }

    static class Solution {
        public static boolean isValid(String s) {
            if(s.length() == 1) return false;

            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (map.containsKey(c)) {
                    char topElement = stack.empty() ? '#' : stack.pop();

                    if (topElement != map.get(c)) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }
    }
}
