package leetcode;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.println(Solution3.longestCommonPrefix
                (new String[]{"flower","flow","flight"}));
    }

    static class Solution3 {
        public static String longestCommonPrefix(String[] strs) {
            int strsLength = strs.length;
            if(strs.length == 0) return "";

            int min = strs[0].length();
            String prefix = strs[0];
            for(int i = 1; i < strsLength; i++){
                min = (min <= strs[i].length())? min : strs[i].length();
                while (min > 0) {
                    prefix = prefix.substring(0, min);
                    String sub = strs[i].substring(0, min);
                    if(prefix.equals(sub)) {
                        break;
                    } else {
                        min --;
                    }
                }
                if(min == 0) {
                    return "";
                }
            }
            return prefix;
        }
    }


    static class SolutionHorizontal {
        public static String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++)
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            return prefix;
        }
    }

    static class SolutionVertical {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            for (int i = 0; i < strs[0].length() ; i++){
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j ++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c)
                        return strs[0].substring(0, i);
                }
            }
            return strs[0];
        }
    }

    static class SolutionDivideAndConquer {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            return longestCommonPrefix(strs, 0 , strs.length - 1);
        }

        private String longestCommonPrefix(String[] strs, int l, int r) {
            if (l == r) {
                return strs[l];
            }
            else {
                int mid = (l + r)/2;
                String lcpLeft =   longestCommonPrefix(strs, l , mid);
                String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
                return commonPrefix(lcpLeft, lcpRight);
            }
        }

        String commonPrefix(String left,String right) {
            int min = Math.min(left.length(), right.length());
            for (int i = 0; i < min; i++) {
                if ( left.charAt(i) != right.charAt(i) )
                    return left.substring(0, i);
            }
            return left.substring(0, min);
        }
    }

    static class SolutionBinarySearch {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0)
                return "";
            int minLen = Integer.MAX_VALUE;
            for (String str : strs)
                minLen = Math.min(minLen, str.length());
            int low = 1;
            int high = minLen;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (isCommonPrefix(strs, middle))
                    low = middle + 1;
                else
                    high = middle - 1;
            }
            return strs[0].substring(0, (low + high) / 2);
        }

        private boolean isCommonPrefix(String[] strs, int len){
            String str1 = strs[0].substring(0,len);
            for (int i = 1; i < strs.length; i++)
                if (!strs[i].startsWith(str1))
                    return false;
            return true;
        }
    }

//    static class Solution {
//        public static String longestCommonPrefix(String[] strs) {
//            if(strs == null || strs.length == 0){
//                return null;
//            }
//            if(strs.length == 1) {
//                return strs[0];
//            }
//            Trie trie = new Trie();
//            String prefix = "";
//            char first = strs[0].charAt(0);
//            for(int i = 0; i < strs.length; i++) {
//                if (strs[i].length() == 0 || first != strs[i].charAt(0)) {
//                    return "";
//                }
//                prefix = trie.insert(strs[i]);
//                first = strs[i].charAt(0);
//            }
//            return prefix;
//        }
//
//        public class TrieNode {
//            public int pass;
//            public int end;
//            public TrieNode[] next;
//
//            public TrieNode() {
//                pass = 0;
//                end = 0;
//                next = new TrieNode[26];
//            }
//        }
//
//        public class Trie {
//            private TrieNode root;
//            public Trie() {
//                root = new TrieNode();
//            }
//
//            public String insert(String word) {
//                if(word == null) {
//                    return "";
//                }
//                char[] chars = word.toCharArray();
//                TrieNode node = root;
//                node.pass++;
//                int index = 0;
//                int maxPass = 0;
//                StringBuilder prefix = new StringBuilder();
//                for(int i = 0; i < chars.length; i++) {
//                    index = chars[i] - 'a';
//                    if(node.next[index] == null) {
//                        node.next[index] = new TrieNode();
//                    }
//                    node = node.next[index];
//                    node.pass++;
//                    if(node.pass >= maxPass && node.pass != 1) {
//                        prefix.append(chars[i]);
//                        maxPass = node.pass;
//                    }
//                }
//                node.end++;
//                return prefix.toString();
//            }
//        }
//    }


}



