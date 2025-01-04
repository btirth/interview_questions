class Solution {
    public int minCostToMoveChips(int[] position) {
        /**
        for each position calculate score -> O(n^2)

        is there any optimal solution?
        if the selected position is odd -> odd values doesn't matter because any how diff would be |2|
        calculate coins on odd and even number
        ans = Math.min(odd, even)
        
        */
        int oddCoins = 0;
        int evenCoins = 0;
        int n = position.length;

        for(int i=0; i<n; i++) {
            if(position[i] % 2 == 0) {
                evenCoins++;

            } else {
                oddCoins++;
            }
        }

        return Math.min(evenCoins, oddCoins);
    }
}