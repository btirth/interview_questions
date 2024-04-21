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
        int req = 0;
        for(int pile: piles) {
            req += Math.ceil((double)pile/k);
        }

        return req <= h;
    }
}