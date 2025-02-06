class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile: piles) {
            right = Math.max(right, pile);
        }

        int ans=0;
        while(left <= right) {
            int mid = (right + left) / 2;
            if(isPossible(piles, h, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int[] piles, int h, int max) {
        for(int pile: piles) {
            h -= (int)Math.ceil((1.0*pile)/max);

            if(h < 0) {
                return false;
            }
        }

        return true;
    }
}