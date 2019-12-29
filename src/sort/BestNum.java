package sort;

import java.util.Arrays;
import java.util.Comparator;

public class BestNum {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 33,30, 34, 5, 9}));
    }
}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int numLength = numbers.length;
        String[] strArr = new String[numLength];

        for(int i = 0; i < numLength; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if(strArr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numLength; i++) {
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
}

class Solution1 {
    public String solution(int[] numbers) {
        String answer = "";
        int numLength = numbers.length;
        String[] strArr = new String[numLength];

        for(int i = 0; i < numLength; i++) {

            strArr[i] = String.valueOf((numbers[i] < 10)? numbers[i] + "" +numbers[i] + "*" : numbers[i]);
        }

        Arrays.sort(strArr, Comparator.reverseOrder());


        for(int i = 0; i < numLength; i++) {
            if(strArr[i].contains("*")){
                strArr[i] = strArr[i].substring(0,1);
            }
            answer += strArr[i];
        }
        return answer;
    }
}

