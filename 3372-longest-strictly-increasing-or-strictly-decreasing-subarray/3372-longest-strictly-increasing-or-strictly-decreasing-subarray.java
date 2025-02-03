class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int lenInc = 1;
        int lenDes = 1;
        int n = nums.length;
        for(int i=1; i<n; i++) {
            if(nums[i] > nums[i-1]) {
                lenInc++;
                ans = Math.max(ans, lenDes);
                lenDes = 1;
            } else if(nums[i] < nums[i-1])  {
                lenDes++;
                ans = Math.max(ans, lenInc);
                lenInc = 1;
            } else {
                ans = Math.max(ans, lenDes);
                lenDes = 1;
                ans = Math.max(ans, lenInc);
                lenInc = 1;
            }
        }

        ans = Math.max(ans, lenInc);
        ans = Math.max(ans, lenDes);

        return ans;
    }
}