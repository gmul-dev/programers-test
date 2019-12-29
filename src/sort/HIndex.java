package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HIndex {

    public static void main(String[] args) {

        System.out.println(HIndexSolution.solution(new int[]{5,5,5,5,5}));
    }
}

class HIndexSolution {
    public static int solution(int[] citations) {
        int answer = 0;
        int citationsLength = citations.length;

        Arrays.sort(citations);

        for(int i = 0; i < citationsLength; i++) {
            answer = citationsLength - i;
            if(citations[i] >= answer) {
                return answer;
            }

        }

        return 0;
    }
}
