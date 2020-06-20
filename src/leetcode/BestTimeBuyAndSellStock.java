package leetcode;

import sun.awt.image.IntegerComponentRaster;

public class BestTimeBuyAndSellStock {
    public static void main(String[] args) {
       // System.out.println(Solution.isValid("([])"));
        System.out.println(Solution.maxProfit(new int[]{2,4,1}));
    }

    static class Solution {
        public static int maxProfit(int[] prices) {
            if(prices.length == 0 || prices.length == 1) return 0;
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;
            for(int i = 0; i < prices.length; i++) {
                int price = prices[i];
                if(minPrice > price){
                    minPrice = price;
                }
                else if (price - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
            return maxProfit;
        }
    }
}
