package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println('[' - '{');
       // System.out.println(Solution.isValid("([])"));
        System.out.println(Solution.isValid("{[]}"));

    }

    static class Solution {
        public static boolean isValid(String s) {
            char[] chars = s.toCharArray();
            Stack charStack = new Stack();

            for(int i = 0; i < chars.length; i++) {
                if(charStack.empty()) {
                    charStack.push(chars[i]);
                } else {
                    int num =  chars[i] - (char)charStack.peek();
                    if(num == 2 || num == 1) {
                        charStack.pop();
                    } else {
                        charStack.push(chars[i]);
                    }
                }
            }
//            if(charStack.empty()) {
//                return true;
//            } else {
//                return false;
//            }
            return charStack.isEmpty();
        }
    }

    class SolutionGood {

        private HashMap<Character, Character> mappings;

        public SolutionGood() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (this.mappings.containsKey(c)) {
                    char topElement = stack.empty() ? '#' : stack.pop();
                    if (topElement != this.mappings.get(c)) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }

    class SolutionBest {
        public boolean isValid(String s){
            if(s.length()%2==1) return false;  // a string of odd length cannot be balanced parentheses

            HashMap<Character,Character> hm = new HashMap<>();
            hm.put(')','(');
            hm.put('}','{');
            hm.put(']','[');

            Stack<Character> st=new Stack<>();

            for(char c:s.toCharArray()){
                if(c=='(' || c=='{' || c=='[')
                    st.push(c);
                else{
                    if(st.isEmpty()) return false;

                    char p = st.pop();
                    if(p!=hm.get(c)) return false;
                }
            }
            return st.isEmpty();
        }
    }
}
