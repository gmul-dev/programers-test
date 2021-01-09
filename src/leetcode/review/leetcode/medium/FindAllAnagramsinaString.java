package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString {

    public static void main(String[] args) {
        System.out.println(Solution.findAnagrams("cbaebabacd", "abc"));
    }

    static class Solution {
        public static List<Integer> findAnagrams(String s, String p) {

            List<Integer> res =  new ArrayList();
            int[] map = new int[128];
            for(char c:p.toCharArray()) map[c]++;
            int cnt = p.length();

            int j = 0;
            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                if(map[c]>0) cnt--;
                map[c]--;
                while(cnt == 0){
                    if(i-j+1 == p.length()){
                        res.add(j);
                    }
                    if(++map[s.charAt(j)]>0) cnt++;
                    j++;
                }
            }
            return res;
        }
    }



    // time limit exception
    static class SolutionBruteForce {
        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> lst = new ArrayList<>();

            int l = p.length();
            char[] arr = p.toCharArray();
            Arrays.sort(arr);
            String newstr = new String(arr);

            for(int i=0;i<=s.length()-l;i++){
                String str = s.substring(i,i+l);
                char[] arr2 = str.toCharArray();
                Arrays.sort(arr2);
                String str2 = new String(arr2);
                if(str2.equals(newstr)){
                    lst.add(i);
                }
            }

            return lst;
        }
    }
}
