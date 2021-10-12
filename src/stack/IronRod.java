package stack;

import java.util.*;

public class IronRod {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        System.out.println(IronRodSolution.solutionNew("()(((()())(())()))(())"));
    }

    static class IronRodSolution {
        public static int solutionNew(String arrangement) {
            int answer = 0;
            int rodCnt = 0;
            arrangement = arrangement.replace("()", "|");

            int arragementLength = arrangement.length();
            for(int i = 0; i < arragementLength; i++){
                char c = arrangement.charAt(i);

                if(c == '(') {
                    rodCnt++;
                } else if(c == '|') {
                    answer += rodCnt;
                } else {
                    rodCnt--;
                    answer++;
                }
            }
            return answer;
        }

        public static int solutionOld(String arrangement) {
            int answer = 0;
            int rodCount = 0;
            String[] arrangementArr = arrangement.split("");
            Stack<String> arrangementStack = new Stack<>();

            int arrangementLength = arrangementArr.length;

            for (int i = arrangementLength - 1; i >= 0; i--)
                arrangementStack.push(arrangementArr[i]);

            String item = arrangementStack.pop();
            String nextItem = arrangementStack.pop();
            while (!arrangementStack.isEmpty()) {
                String plusItem = item + nextItem;

                if (plusItem.equals("((")) {
                    rodCount++;
                } else if (plusItem.equals("()")) {
                    answer += rodCount;
                } else if (plusItem.equals("))")) {
                    rodCount--;
                    answer++;
                } else {
                }

                item = nextItem;
                nextItem = arrangementStack.pop();
            }

            return answer + rodCount;
        }
    }
}
