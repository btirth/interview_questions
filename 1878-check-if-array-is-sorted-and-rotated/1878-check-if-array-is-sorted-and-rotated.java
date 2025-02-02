class Solution {
    public boolean check(int[] nums) {
        int maxNum = nums[0];
        boolean reversed = false;
        int n = nums.length;
        for(int i=1; i<n; i++) {
            if(!reversed) {
                if(nums[i] < nums[i-1]) {
                    if(nums[i] > maxNum) {
                        return false;
                    }
                    
                    reversed = true;    
                }
            } else if(reversed) {
                if(nums[i] < nums[i-1] || nums[i] > maxNum) {
                    return false;
                }
            }
        }

        return true;
    }
}