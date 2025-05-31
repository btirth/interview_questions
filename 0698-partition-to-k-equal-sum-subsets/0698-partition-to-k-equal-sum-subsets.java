class Solution {
    HashMap<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {
        /**
        I can do backtracking or binary search


        
         */
        int n = nums.length;
        int sum = 0;
        for(int num: nums) {
            sum += num;
        } 

        if(sum % k != 0) {
            return false;
        }

        int target = sum / k;
        

        int res = helper(nums, k, 0, 0, target);
        System.out.println(res);
        return res == k;
    }

    int helper(int[] nums, int k, int mask, int sum, int target) {
        if(sum == target) {
            return 1 + helper(nums, k, mask, 0, target);
        }

        Pair p = new Pair(sum, mask);
        if(dp.containsKey(p)) {
            return dp.get(p);
        }

        int max = 0;
        for(int i=0; i<nums.length; i++) {
            // We need to check if ith bit is set ornot
            // mask & (1 << i) > 1
            int bit = mask & (1 << i);
            if(bit == 0 && sum + nums[i] <= target) {
                max = Math.max(max, helper(nums, k, mask | (1 << i), sum + nums[i], target));
            }
        }

        dp.put(p, max);
        return max;
    }
}