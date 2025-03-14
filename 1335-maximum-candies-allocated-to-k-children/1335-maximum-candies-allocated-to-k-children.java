class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int n = candies.length;
        int start = 1;
        int end = candies[n - 1];
        int ans = 0;
        
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