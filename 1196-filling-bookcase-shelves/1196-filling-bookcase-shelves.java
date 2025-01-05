class Solution {
    int[] dp;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new int[books.length];
        return helper(books, 0, 0, shelfWidth, 0);
    }

    int helper(int[][] books, int idx, int currWidth, int shelfWidth, int currShelfH) {
        if(idx == books.length) {
            return currShelfH;
        }

        if(dp[idx] == 0) {
            dp[idx] = helper(books, idx + 1, books[idx][0], shelfWidth, books[idx][1]);
        }
        
        int minVal = dp[idx] + currShelfH;
        if(currWidth + books[idx][0] <=  shelfWidth) {
            minVal = Math.min(minVal, helper(books, idx + 1, currWidth + books[idx][0], shelfWidth, Math.max(currShelfH, books[idx][1])));
        }

        return minVal;
    }
}