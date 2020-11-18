package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(Solution.partitionLabels("ababcbacadefegdehijhklij"));
    }

    static class Solution {
        public static List<Integer> partitionLabels(String S) {
            List<Integer> result = new ArrayList<>();
            int[] last = new int[26];

            for(int i = 0; i < S.length(); i++) {
                last[S.charAt(i) - 'a'] = i;
            }

//            int j = 0, anchor = 0;
//            for (int i = 0; i < S.length(); ++i) {
//                j = Math.max(j, last[S.charAt(i) - 'a']);
//                if (i == j) {
//                    result.add(i - anchor + 1);
//                    anchor = i + 1;
//                }
//            }

            int i =0;
            while(i < S.length()){
                int end = last[S.charAt(i) - 'a'];
                int j = i;
                while(j < end){
                    end =  Math.max(end , last[S.charAt(j++) - 'a']);
                }
                result.add(j-i+1);
                i = j+1;
            }

            return result;
        }
    }
}
