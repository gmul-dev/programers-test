package stack;

import java.util.*;

public class Printer {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        System.out.println(PrinterSolution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    static class PrinterSolution {
        public static int solution(int[] priorities, int location) {
            int answer = 1;
            PriorityQueue<Integer> priorityQ = new PriorityQueue<>(Collections.reverseOrder());

            for(int priority : priorities)
                priorityQ.add(priority);

            while(!priorityQ.isEmpty()) {
                for(int i = 0; i < priorities.length; i++) {
                    if(priorities[i] == priorityQ.peek()) {
                        if(i == location) return answer;
                        priorityQ.poll();
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
}
