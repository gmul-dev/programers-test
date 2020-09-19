package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        System.out.println(Solution.findAnagrams("asdfadfasdfasdf", "as"));
    }

    static class Solution {
        public static List<Integer> findAnagrams(String ss, String pp) {
            List<Integer> res = new ArrayList<>();
            int[] count = new int[128];
            char[] s = ss.toCharArray();
            char[] p = pp.toCharArray();
            int match = 0;

            for (int i = 0; i < p.length; i++) {
                count[p[i]]++;
            }

            int l = 0;
            for (int r = 0; r < s.length; r++) {
                // check if p has the letter
                if (count[s[r]] > 0) {
                    match++;
                }

                count[s[r]]--;

                // maintain the window
                while (r - l + 1 > p.length) {
                    // check s[l] has already counted
                    if (count[s[l]] >= 0) {
                        match--;
                    }

                    count[s[l++]]++;
                }

                // check validation
                if (r - l + 1 == p.length && match == p.length) {
                    res.add(l);
                }
            }

            return res;
        }
    }
}
