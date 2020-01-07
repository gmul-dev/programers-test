package stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StockPrice {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        System.out.println(StockPriceSolution.solution(new int[]{1, 2, 3, 2, 3}));
    }

}

class StockPriceSolution {
    public static int[] solution(int[] prices) {
        int priceLength = prices.length;
        int[] answer = new int[priceLength];

        for(int i = 0; i < priceLength; i++){
            for(int j = i + 1; j < priceLength; j++){
                if(prices[i] > prices[j] || j == priceLength - 1) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }
}
