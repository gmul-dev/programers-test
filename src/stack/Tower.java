package stack;

import java.util.Arrays;
import java.util.Stack;

public class Tower {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3,9,9,3,5,7,2}));
    }

    static class Solution {
        public int[] solution(int[] heights) {
            int[] answer = new int[heights.length];
            Stack<Integer> towerStack = new Stack<>();

            for (int i = 0; i < heights.length; i++) {
                towerStack.push(heights[i]);
                answer[i] = 0;
            }

            while (!towerStack.isEmpty()) {
                int towerNum = towerStack.pop();

                for (int j = towerStack.size(); j >= 0; j--) {
                    if (towerNum < heights[j]) {
                        answer[towerStack.size()] = j + 1;
                        break;
                    }
                }
            }
            return answer;
        }
    }


    class Solution1 {
        public int[] solution(int[] heights) {
            int[] answer = new int[heights.length];
            Stack<Integer> towerStack = new Stack<>();
            Stack<Integer> towerTemp = new Stack<>();
            int pass = 0;

            for(int i = 0; i < heights.length; i++){
                towerStack.push(heights[i]);
                answer[i] = 0;
            }

            for(int j = towerStack.size() - 1; j >= 0; j--){

                if(towerStack.empty()){
                    return answer;
                }

                int towerNum = towerStack.pop();
                int nextNum = towerStack.pop();
                if(towerNum < nextNum){
                    answer[j] = j;
                    pass++;
                }else{
                    if(towerTemp.empty()){
                        towerTemp.push(towerNum);
                    }else if(!towerStack.empty() && !towerTemp.empty()){
                        int tempNum = towerTemp.pop();
                        if(towerNum > tempNum){
                            answer[pass + j + towerTemp.size() + 1] = j + 1;
                            towerStack.push(towerNum);
                            pass++;
                            if(!towerTemp.empty()) j++;
                        }else{
                            towerTemp.push(tempNum);
                            towerTemp.push(towerNum);
                        }
                    }
                }
                towerStack.push(nextNum);
            }
            return answer;
        }
    }

}

