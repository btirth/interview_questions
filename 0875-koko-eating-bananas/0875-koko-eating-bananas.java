class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];

        for(int pile: piles) {
            high = Math.max(high, pile);
        }

        int res = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (high + low) / 2;
            if(isPossible(piles, mid, h)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    public boolean isPossible(int[] piles, int k, int h) {
        int requiredHours = 0;

        for(int pile: piles) {
            requiredHours += pile / k;
            if((pile % k) != 0) {
                requiredHours++;
            }
            if(requiredHours > h) {
                return false;
            }
        }

        return true;
    }
}