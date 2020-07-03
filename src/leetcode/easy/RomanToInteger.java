package leetcode.easy;

import java.util.*;

public class RomanToInteger {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("LVIII"));
    }

    static class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> romanNum = new HashMap<>();
            romanNum.put('I', 1); romanNum.put('V', 5);
            romanNum.put('X', 10); romanNum.put('L', 50);
            romanNum.put('C', 100); romanNum.put('D', 500);
            romanNum.put('M', 1000);

            int result = 0;
            int sLength = s.length();
            for(int i = 0; i < sLength; i++) {
                int v = romanNum.get(s.charAt(i));
                if(i != sLength - 1 && v < romanNum.get(s.charAt(i + 1))) {
                    result -= v;
                }else{
                    result += v;
                }
            }
            return result;
        }
    }
}
