package stack;

import java.util.*;

public class BridgeTruck {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0;

        List<Truck> bridgeList = new ArrayList<>();
        Queue<Truck> waitQueue = new LinkedList<>();

        for (int truckWeight : truck_weights)
            waitQueue.add(new Truck(truckWeight, bridge_length));

        while (!(waitQueue.isEmpty() && bridgeList.isEmpty())) {
            answer++;

            if (!bridgeList.isEmpty() && bridgeList.get(0).length <= 0) {
                weight += bridgeList.get(0).weight;
                bridgeList.remove(0);
            }

            if (!waitQueue.isEmpty() && weight - waitQueue.peek().weight >= 0) {
                weight -= waitQueue.peek().weight;
                bridgeList.add(waitQueue.poll());
            }

            bridgeList.forEach(truck -> truck.length--);
        }
        return answer;
    }

    static class Truck {
        int weight;
        int length;

        public Truck(int weight, int length) {
            this.weight = weight;
            this.length = length;
        }
    }
}







//class Solution {
//    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        //total_time
//        int answer = 0;
//        int bridgeWeight = 0;
//        int weightLength = truck_weights.length;
//        int tempTime = 0;
//
//        for(int i = 0; i < weightLength; i++){
//            if(tempTime == 0){
//                tempTime = bridge_length;
//                bridgeWeight += truck_weights[i];
//            } else {
//                if(bridgeWeight + truck_weights[i] <= weight){
//                    bridgeWeight += truck_weights[i];
//                    tempTime++;
//                }else{
//                    answer += tempTime;
//                    bridgeWeight = 0;
//                    tempTime = 0;
//                    i--;
//                }
//            }
//
//            if(i == weightLength - 1){
//                answer += tempTime;
//            }
//        }
//        return ++answer;
//    }
//}
