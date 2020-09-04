package leetcode.medium;

public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        System.out.println(Solution.maxProfit(new int[]{1,2,3,0,2}));
    }

//    buy[i] : 트랜잭션이 buy로 끝나는 최대 이익을 실현하는 거래 순서
//    sell[i] : 트랜잭션이 sell로 끝나는 최대 이익을 실현하는 거래 순서
//    rest[i] : 트랜잭션이 rest 즉 계속 보유하는 것으로 끝나는 최대 이익을 실현하는 거래 순서
//
//    buy[i], sell[i], rest[i]는 각각에 대하여
//
//    buy[i] = max(buy[i-1], rest[i-1] - prices)
//    sell[i] = max(buy[i-1] + prices, sell[i-1])
//    rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
//
//    로 나타낼 수 있다. 이 중 buy[i] <= rest[i] <= sell[i] 를 만족하므로 위 식은 다음과 같이 된다.
//
//    buy[i] = max(buy[i-1], sell[i-2] - prices)
//    sell[i] = max(buy[i-1] + prices, sell[i-1])
//
//    출처: https://engkimbs.tistory.com/699 [새로비]

    static class Solution {
        public static int maxProfit(int[] prices) {

//            int n = prices.length;
//            if (n <= 1) return 0;
//            //거래가 buy로 끝나는 최대 이익을 실현하는 거래 순서
//            int[] buy = new int[n + 1];
//            //거래 sell로 끝나는 최대 이익을 실현하는 거래 순서
//            int[] sell = new int[n + 1];
//            buy[1] = -prices[0];
//            for (int i = 2; i <= n; i++) {
//                // 구매 x -> [i-1]의 이익 그대로, 구매 o -> 판매 배열에서의 이익 값에 - 주식가격 :: 쿨다운이 있으므로 판다음엔 사지 못함 즉 sell[i-2]의 값으로 계산해야 최대 이익
//                // buy[i] = max( 구매 x, 구매 o)
//                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
//                // 판매 x -> [i-1]의 이익 그대로, 판매 o -> 구매 후 이익 + 현재 주식가격(판매 이익) :: 판매하기위해서는 그전에 구매가 이루어졌어야함
//                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1]);
//            }
//            return sell[n];
//

            int curr_sell=0;
            int prev_sell=0;
            int curr_buy = Integer.MIN_VALUE;
            for(int price : prices){
                int temp = curr_sell;
                curr_buy  = Math.max(curr_buy,prev_sell-price);
                curr_sell = Math.max(curr_sell,curr_buy+price);
                prev_sell = temp;
            }
            return curr_sell;
        }
    }
}
