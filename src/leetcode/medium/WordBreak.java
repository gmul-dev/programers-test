package leetcode.medium;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");
        SolutionWordBreak solution = new SolutionWordBreak();
        System.out.println(solution.wordBreak("cars",wordDict));
    }
}

class SolutionWordBreak {
    public boolean wordBreak(String s, List wordDict) {
        Map<String, Boolean> cache = new HashMap<>();
        return helper(s, wordDict, cache);
    }

    private boolean helper(String s, List<String> wordDict, Map<String, Boolean> cache) {
        if (s.isEmpty()) return true;       // base case

        // see if already calcualted for this string
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        // iterate through wordDict
        for (int i = 0; i < wordDict.size(); i++) {
            String currWord = wordDict.get(i);
            int currWordSize = currWord.length();
            if (s.startsWith(currWord)) {       // match string, subtract from beginning and then recurse with substring
                String subString = s.substring(currWordSize);
                boolean isPass = helper(subString, wordDict, cache);
                if (isPass) return true;
            }
        }

        cache.put(s, false);
        return false;
    }
}
