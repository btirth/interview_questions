class Solution {
    List<Integer>[] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        dp = new ArrayList[n];
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            List<Integer> temp = helper(nums, i);
            if(temp.size() > ans.size()) {
                ans = temp;
            }
        } 

        return ans;
    }

    List<Integer> helper(int[] nums, int idx) {
        if(dp[idx] != null) {
            return dp[idx];
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[idx]);
        for(int i=idx+1; i<nums.length; i++) {
            if(nums[i]%nums[idx] == 0) {

                List<Integer> temp = new ArrayList<>();
                temp.add(nums[idx]);
                temp.addAll(helper(nums, i));
                if(temp.size() > ans.size()) {

                    ans = temp;
                }
            }
        }

        return dp[idx] = ans;
    }
}