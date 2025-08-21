class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        /**
        for every num I've 2 options:
        + or -

        fun(nums, target):
            return func(nums, target - num) + func(nums, target + num)
        

         */

        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n + 1];

        for(int i=0; i<=n; i++) {
            dp[i] = new HashMap<>();
        }

        dp[0].put(0,1);

        for(int i=0; i<n; i++) {
            for(Map.Entry<Integer, Integer> entry: dp[i].entrySet()) {
                int trgt = entry.getKey();
                int freq = entry.getValue();

                dp[i + 1].put(trgt - nums[i], dp[i+1].getOrDefault(trgt - nums[i], 0) + freq);
                dp[i + 1].put(trgt + nums[i], dp[i+1].getOrDefault(trgt + nums[i], 0) + freq);
            }
        }

        return dp[n].getOrDefault(target, 0);
    }

    // int findTargetSumWays(int[] nums, int target, int idx, int totalSum) {
    //     if(idx == nums.length || target > totalSum || target < (-1*totalSum)) {
    //         if(target == 0) {
    //             return 1;
    //         }

    //         return 0;
    //     }

    //     if(dp[idx][target + totalSum] != null) {
    //         return dp[idx][target + totalSum];
    //     }

    //     int ways = 0;
    //     ways += findTargetSumWays(nums, target + nums[idx], idx + 1, totalSum);
    //     ways += findTargetSumWays(nums, target - nums[idx], idx + 1, totalSum);

    //     return dp[idx][target + totalSum] = ways;
    // }
}