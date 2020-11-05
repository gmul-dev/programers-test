package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(Solution.partitionLabels("ababcbacadefegdehijhklij"));
    }

    static class Solution {
        public static List<Integer> partitionLabels(String S) {
            List<Integer> result = new ArrayList<>();
            int[] visited = new int[26];
            helper(S, result, visited);
            return result;
        }

        private static void helper(String s, List<Integer> result, int[] visited) {
            if("".equals(s)) return;

            int i = 0;
            int lastIndex = 0;
            while (i <= lastIndex) {
                char c = s.charAt(i);
                if(visited[c - 'a'] > 0) {
                    i++;
                    continue;
                }
                visited[c - 'a']++;
                lastIndex = Math.max(lastIndex, s.lastIndexOf(c));
                i++;
            }
            result.add(lastIndex + 1);
            helper(s.substring(lastIndex + 1), result, visited);
        }
//        public static List<Integer> partitionLabels(String s) {
//            List<Integer> result = new ArrayList<>();
//            int[] last = new int[26];
//
//            for(int i = 0; i < s.length(); i++) {
//                last[s.charAt(i) - 'a'] = i;
//            }
//
//            int start = 0, end = 0;
//            for(int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                end = Math.max(last[c - 'a'], end);
//                if(i == end) {
//                    result.add(end - start + 1);
//                    start = end + 1;
//                }
//            }
//            return result;
//        }
    }
}
