class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] goodSubArray = new int[n];
        goodSubArray[0] = 1;
        for(int i=1; i<n; i++) {
            if(nums[i]%2 == nums[i-1]%2) {
                goodSubArray[i] = goodSubArray[i-1] + 1;
            } else {
                goodSubArray[i] = goodSubArray[i-1];
            }
        }

        int len = queries.length;
        boolean[] ans = new boolean[len];

        for(int i=0; i<len; i++) {
            ans[i] = goodSubArray[queries[i][0]] == goodSubArray[queries[i][1]];
        }

        return ans;
    }
}