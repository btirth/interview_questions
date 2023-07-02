class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        int l = -1;
        int r = 0;
        int n = nums.length;
        
        while(r < n) {
            if(nums[r] > threshold) {
                if(l != -1)
                    ans = Math.max(ans, r-l);
                l = -1;
            } else {
                if(l == -1) {
                    if(nums[r]%2 == 0) {
                        ans = Math.max(ans, 1);
                        
                        if(r<n-1 && nums[r]%2 != nums[r+1]%2) {
                            l = r;
                        }
                    }
                } else {
                    if(r<n-1 && nums[r]%2 == nums[r+1]%2) {
                        ans = Math.max(ans, r-l+1);
                        l = -1;
                    }
                }
            }
            
            r++;
        }
        
        if(l != -1)
            ans =  Math.max(ans, r-l);
        
        return ans;
    }
}