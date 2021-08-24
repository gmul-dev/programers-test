package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        SolutionOther so = new SolutionOther();
        System.out.println(so.decodeString("3[a2[c]]"));
    }

    static class Solution {
        public static String decodeString(String s) {

            if(s.length() == 0)
                return s;

            StringBuilder sb = new StringBuilder();

            int a = 0;
            int b = 0;

            while(a < s.length()) {

                if(!Character.isDigit(s.charAt(a))) {
                    sb.append(s.charAt(a));
                    a++;
                    b++;
                } else {
                    while(s.charAt(b) != '[')
                        b++;

                    int num = Integer.parseInt(s.substring(a,b));

                    a = b;

                    int open = 1;
                    while(open != 0) {
                        b++;

                        if(s.charAt(b) == '[') {
                            open++;
                        } else if(s.charAt(b) == ']') {
                            open--;
                        }
                    }

                    String enclosure = decodeString(s.substring(a+1, b));
                    b++;

                    for (int i = 0; i < num; i++) {
                        sb.append(enclosure);
                    }

                    a = b;
                }
            }
            return sb.toString();
        }
    }
}

class SolutionOther {
    int idx;

    public String decodeString(String s) {
        idx = 0;
        return helper(s);
    }

    String helper(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(; idx < s.length(); idx++) {
            char ch = s.charAt(idx);
            if(ch == '[') {
                idx++;
                String str = helper(s);
                while (k > 0) {
                    sb.append(str);
                    k--;
                }
            } else if (ch == ']') {
                break;
            } else if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
