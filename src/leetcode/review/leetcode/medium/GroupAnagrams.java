package leetcode.review.leetcode.medium;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(Solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    static class Solution {
        public static List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            Map<Integer, List<String>> map = new HashMap<>();

            for(String str: strs){
                int sum = 1;
                int total = 0;
                for(int i=0; i < str.length(); i++){
                    int intVal = str.charAt(i);
                    sum = sum *intVal;
                    total = total + intVal;
                }
                // create unique key
                sum = sum + total;

                if(map.containsKey(sum)){
                    map.get(sum).add(str);
                }else{
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(sum, list);
                    result.add(list);
                }
            }
            return result;
        }

//        public List<List<String>> groupAnagrams(String[] strs) {
//            if (strs.length == 0) return new ArrayList();
//            Map<String, List> ans = new HashMap<String, List>();
//            for (String s : strs) {
//                char[] ca = s.toCharArray();
//                Arrays.sort(ca);
//                String key = String.valueOf(ca);
//                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//                ans.get(key).add(s);
//            }
//            return new ArrayList(ans.values());
//        }
    }

    static class MySolution {
        public static List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            if(strs.length == 0 || strs.length == 1) {
                result.add(new ArrayList(Arrays.asList(strs)));
                return result;
            }

            for(int i = 0; i < strs.length; i++) {
                if(strs[i].equals("-")) continue;
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                for(int j = i + 1; j < strs.length; j++) {
                    if(strs[j].equals("-")) continue;

                    char[] ch1 = strs[i].toCharArray();
                    char[] ch2 = strs[j].toCharArray();
                    Arrays.sort(ch1);
                    Arrays.sort(ch2);

                    if(Arrays.equals(ch1, ch2)){
                        list.add(strs[j]);
                        strs[j] = "-";
                    }
                }
                result.add(new ArrayList<>(list));
            }

            return result;
        }
    }
}
