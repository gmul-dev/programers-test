package leetcode.medium;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(Solution.isAnagram("anagram", "nagaram"));
    }

    static class Solution {
        public static boolean isAnagram(String s, String t) {
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);

            char[] tChars = t.toCharArray();
            Arrays.sort(tChars);

            return String.valueOf(sChars).equals(String.valueOf(tChars));
        }
    }

    static class SolutionBest {
        public static boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) return false;

            int[] map = new int[26];

            for(char a: s.toCharArray()){
                map[a - 'a']++;
            }

            for(char c: t.toCharArray()){
                map[c - 'a']--;
            }

            for(int i: map){
                if(i != 0) return false;
            }

            return true;
        }
    }
}
