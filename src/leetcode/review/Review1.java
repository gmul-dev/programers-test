package leetcode.review;

import java.util.HashMap;
import java.util.Map;

//LongestSubstringWithoutRepeatingCharacters
public class Review1 {

    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("pwwkew"));
    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
//            int n = s.length(), ans = 0;
//            Map<Character, Integer> map = new HashMap<>(); // current index of character
//            // try to extend the range [i, j]
//            for (int j = 0, i = 0; j < n; j++) {
//                if (map.containsKey(s.charAt(j))) {
//                    i = Math.max(map.get(s.charAt(j)), i);
//                }
//                ans = Math.max(ans, j - i + 1);   //
//                map.put(s.charAt(j), j + 1);      // 요소가 1개 일때를 반영하기 위해 + 1
//            }
//            return ans;

            int idx[] = new int[128];
            int ans = 0;
            for (int j = 0, i = 0; j < s.length(); j++) {
                i = Math.max(i, idx[s.charAt(j)]);
                ans = Math.max(ans, j - i + 1);
                idx[s.charAt(j)] = j + 1;
            }
            return ans;
        }
    }
}
