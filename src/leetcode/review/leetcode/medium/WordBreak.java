package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(Solution.wordBreak("leetcodeleet", list));
    }

    static class Solution {
        public static boolean wordBreak(String s, List<String> wordDict) {
            boolean[] f = new boolean[s.length() + 1];
            f[s.length()] = true;
            for (int i = s.length() - 1; i >= 0; i--) {
                String px = s.substring(i);
                for (String w : wordDict) {
                    if (px.startsWith(w) && f[i + w.length()]) {
                        f[i] = true;
                        break;
                    }
                }
            }
            return f[0];
        }
    }
}
