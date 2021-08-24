package dfsbfs;

import java.util.LinkedList;

public class Gragh {
    private int value;
    private LinkedList<Integer> adj[];

    Gragh (int value) {
        this.value = value;
        this.adj = new LinkedList[value];

        for(int i = 0; i < value; i++)
            this.adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        System.out.println(solution(456789));
    }

    public static int solution(int n) {
        String num = String.valueOf(n);
        while(num.length() > 1){
            num = sumNumber(num);
        }
        return Integer.parseInt(num);
    }

    public static String sumNumber(String num){
        int numLength = num.length();
        int sum = 0;
        for(int i = 0; i < numLength; i++){
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        return String.valueOf(sum);
    }
}

