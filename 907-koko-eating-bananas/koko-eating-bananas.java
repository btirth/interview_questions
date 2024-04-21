class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = 0;
    
        for(int pile: piles) {
            r = Math.max(r, pile);
        }

        if(h == piles.length) {
            return r;
        }

        int minK = r;
        while(l<=r) {
            int k = (l+r)/2;
            if(canEat(piles, h, k)) {
                minK = k;
                r = k-1;
            } else {
                l = k+1;
            }
        }

        return minK;
    }

    boolean canEat(int[] piles, int h, int k) {
        int idx = 0;
        int currH = 0;

        while(currH < h) {
            currH += Math.ceil((double)piles[idx]/k);
            idx++;
            if(currH <= h && idx == piles.length) {
                return true;
            }
        }

        return false;
    }
}