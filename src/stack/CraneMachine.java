package stack;

import java.util.*;

public class CraneMachine {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int moveLength = moves.length;
        int boardLength = board.length;
        Stack<Integer> basket = new Stack<>();

        for(int k = 0; k < moveLength; k++) {
            int line = moves[k] - 1;
            for(int j = 0; j < boardLength; j++) {
                int boardNum = board[j][line];
                if(boardNum > 0){
                    if(!basket.isEmpty() && basket.peek() == boardNum){
                        basket.pop();
                        answer+=2;
                    }else {
                        basket.push(boardNum);
                    }
                    board[j][line] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}

