class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int num: nums) {
            ans += num;
        }
        
        return ((n*(n+1))/2) - ans;
    }
}