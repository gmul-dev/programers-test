package leetcode.review;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Letter Combinations of a Phone Number
public class Review5 {

    public static void main(String[] args) {
        System.out.println(Solution.letterCombinations("23"));
    }

    static class Solution {
        public static List<String> letterCombinations(String digits) {
            LinkedList<String> ans = new LinkedList<>();

            if (digits.length() == 0)
                return ans;

            Map<Character, char[]> map = new HashMap();
            map.put('2', new char[]{'a', 'b', 'c'});
            map.put('3', new char[]{'d', 'e', 'f'});
            map.put('4', new char[]{'g', 'h', 'i'});
            map.put('5', new char[]{'j', 'k', 'l'});
            map.put('6', new char[]{'m', 'n', 'o'});
            map.put('7', new char[]{'p', 'q', 'r', 's'});
            map.put('8', new char[]{'t', 'u', 'v'});
            map.put('9', new char[]{'w', 'x', 'y', 'z'});

            ans.add("");
            while (ans.peek().length() != digits.length()) {
                String extract = ans.poll();
                char[] combos = map.get(digits.charAt(extract.length()));
                for (Character c : combos) {
                    ans.add(extract + c);
                }
            }

            return ans;
        }
    }
}
