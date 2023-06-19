class Solution {
    int count = 0;
    int n;
    int MOD = 1000000007;
    HashMap<String, Integer> dp;
    public int specialPerm(int[] nums) {
        n = nums.length;
        dp = new HashMap<>();
        for(int i=0; i<n; i++) {
            count += helper(nums, 1<<i, 1, nums[i]);
            count %= MOD;
        }
        
       return count;
    }
    
    int helper(int[] nums, int msk, int idx, int prev) {
        if(idx == n) {
            return 1;
        }

        String key = msk + "-" + prev;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int c = 0;
        
        for(int i=0; i<n; i++) {
            if((msk&(1<<i)) == 0 && (nums[i]%prev == 0 || prev%nums[i] == 0)) {
                c += helper(nums, msk|(1<<i), idx+1, nums[i]);
                c %= MOD;
            }
        }

        dp.put(key, c);
        return c;
    }
}