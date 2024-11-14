class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
    
        int left = 0;
        int right = 0;

        for(int quantity: quantities) {
            right = Math.max(right, quantity);
        }

        int ans = 0;
        while(left <= right) {
            int mid = (right + left) / 2;
            if(isPossible(mid, n, quantities)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int max, int n, int[] quantities) {
        for(int quantity: quantities) {
            n -= Math.ceil((double)quantity/max);            
            
            if(n < 0) {
                return false;
            }
        }

        return true;
    }
}