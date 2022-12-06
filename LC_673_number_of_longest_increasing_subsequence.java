/*

Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

Example 1:
  Input: nums = [1,3,5,4,7]
  Output: 2
  Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
  Input: nums = [2,2,2,2,2]
  Output: 5
  Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 
Constraints:
  1 <= nums.length <= 2000
  -10^6 <= nums[i] <= 10^6

*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // to find LIS
        int[] count = new int[n]; // to keep the track of number of LIS ending at i.
        int lis = 1; // LIS
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[j] < nums[i]) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }

            lis = Math.max(lis, dp[i]);
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            if(lis == dp[i]) {
                ans += count[i];
            }
        }

        return ans;
    }
}
