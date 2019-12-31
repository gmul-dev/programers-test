package stack;

import java.util.*;

public class funcDev {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        System.out.println(funcDevSolution.solution(new int[]{93,30,55}, new int[]{1,30,5}));
    }

    static class funcDevSolution {
        public static int[] solution(int[] progresses, int[] speeds) {

            List<Integer> devList = new ArrayList<>();
            Queue<Integer> devQ = new LinkedList<>();

            int progressLength = progresses.length;
            for(int i = 0; i < progressLength; i++){

                int remainPer = 100 - progresses[i];
                int remainDay = remainPer / speeds[i];
                remainDay += (remainPer % speeds[i] == 0)? 0 : 1;

                devQ.add(remainDay);
            }

            int distributeDay = devQ.poll();
            int distributeFunc = 1;
            while (!devQ.isEmpty()){
                int day =  devQ.poll();

                if(day <= distributeDay){
                    distributeFunc++;
                } else {
                    devList.add(distributeFunc);

                    distributeDay = day;
                    distributeFunc = 1;
                }
            }
            devList.add(distributeFunc);

            int listLength = devList.size();
            int[] answer = new int[listLength];
            for(int k = 0; k < listLength; k++){
                answer[k] = devList.get(k);
            }
            return answer;
        }
    }
}

