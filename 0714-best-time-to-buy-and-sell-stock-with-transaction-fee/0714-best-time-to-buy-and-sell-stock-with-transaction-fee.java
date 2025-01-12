class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = 0;
        int sell = 0;
       
        for(int idx=n-1; idx>=0; idx--) {
            
            int tempBuy = Math.max(buy, - prices[idx] + sell);
            int tempSell = Math.max(sell, prices[idx] - fee + buy);    

            buy = tempBuy;
            sell = tempSell;        
        }
        return buy;
    }
}