package leetcode.review.leetcode.easy;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        System.out.println(Solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    static class Solution {
        public static int maxProfit(int[] prices) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }
    }
}
