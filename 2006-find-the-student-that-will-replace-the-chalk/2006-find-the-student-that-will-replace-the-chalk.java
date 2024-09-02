class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int[] dp = new int[n];
        int prefixSum = 0;
        for(int i=0; i<n; i++) {
            if(chalk[i] > k) {
                return i;
            }

            prefixSum += chalk[i];
            dp[i] = prefixSum;
            k -= chalk[i];
        }

        k %= prefixSum;
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = (right + left)/2;
            if(dp[mid] > k) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}