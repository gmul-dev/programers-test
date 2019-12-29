package greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GymSuit {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        Solution solution = new Solution();
        System.out.println(solution.solution(8, new int[] { 2, 4, 5, 7 }, new int[] { 1, 3, 6, 8 }));
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        List<Integer> lostList = new ArrayList<>();
        for (int i : lost) lostList.add(i);

        List<Integer> reserveList = new ArrayList<>();
        for (int i : reserve) reserveList.add(i);

        //reserve이면서 lost인 사람 삭제
        for(Iterator<Integer> itr = lostList.iterator(); itr.hasNext();) {
            int val = itr.next();
            if(reserveList.contains(val)){
                itr.remove();
                reserveList.remove(Integer.valueOf(val));
            }
        }

        for(Iterator<Integer> itr = lostList.iterator(); itr.hasNext();) {
            int val = itr.next();

            if (reserveList.contains(val - 1)) {
                reserveList.remove(Integer.valueOf(val - 1));
                val = -2;
            } else if(reserveList.contains(val + 1)) {
                reserveList.remove(Integer.valueOf(val + 1));
                val = -2;
            }

            if(val < 0){
                itr.remove();
            }
        }

        return n - lostList.size();
    }
}
