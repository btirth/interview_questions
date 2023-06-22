class Solution {
    public int maxProfit(int[] prices) {
        int with = -prices[0];
        int noWith = 0;

        for(int i=0; i<prices.length; i++) {
            with = Math.max(with, noWith-prices[i]);
            noWith = Math.max(noWith, with+prices[i]);
        }

        return Math.max(with, noWith);
    }
}