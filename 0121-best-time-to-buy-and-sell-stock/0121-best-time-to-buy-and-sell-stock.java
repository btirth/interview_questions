class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxValueOnRight = prices[n-1];
        int maxProfit = 0;
        
        for(int i=n-2; i>=0; i--) {
            maxProfit = Math.max(maxProfit, maxValueOnRight - prices[i]);
            maxValueOnRight = Math.max(maxValueOnRight, prices[i]);
        }

        return maxProfit;
    }
}