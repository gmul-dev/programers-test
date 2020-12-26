package leetcode.review.leetcode.medium;

public class BestTimetoBuyandSellStockwithCooldown {

    public static void main(String[] args) {
        System.out.println(Solution.maxProfit(new int[]{1,2,3,0,2}));
    }

    static class Solution {
        public static int maxProfit(int[] prices) {
            int n = prices.length;
            if(n == 0)
                return 0;

            int buy = Integer.MIN_VALUE;
            int sell = 0;
            int cooldown = 0;
            int prevSell = -1;

            for(int i = 0 ; i < n ; i++)
            {
                prevSell = sell;
                sell = Math.max(buy + prices[i], sell);
                buy = Math.max(cooldown + -prices[i] , buy);
                cooldown = Math.max(prevSell , cooldown);
            }

            return sell;
        }
    }

    static class MySolution {
        public static int maxProfit(int[] prices) {
            int max = 0;
            return helper(prices, 0, max, false);
        }

        public static int helper(int[] prices, int idx, int max, boolean isBuy) {

            if(idx >= prices.length) {
                return max;
            }

            int noBuy = helper(prices, idx+1, max, false);
            if(isBuy) {
                return noBuy;
            }

            int buy = helper(prices, idx+1, max-prices[idx], true);

            return Math.max(buy, noBuy);
        }
    }


}
