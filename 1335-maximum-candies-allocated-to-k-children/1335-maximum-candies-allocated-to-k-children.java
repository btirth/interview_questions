class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int start = 1;
        int end = candies[0];
        int ans = 0;

        for(int candy: candies) {
            end = Math.max(end, candy);
        }
        
        while(start <= end) {
            int mid = (start + end) / 2;

            if(isPossible(candies, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    boolean isPossible(int[] candies, long k, int max) {
        long count = 0;
        for(int candy: candies) {
            count += (candy / max);

            if(count >= k) {
                return true;
            }
        }

        return false;
    }
}