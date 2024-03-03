class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] ans1 = new int[n];
        int[] ans2 = new int[n];
        int idx1 = 1;
        int idx2 = 1;
        ans1[0] = nums[0];
        ans2[0] = nums[1];
        
        for(int i=2; i<n; i++) {
            if(ans1[idx1-1] > ans2[idx2-1]) {
                ans1[idx1++] = nums[i];
            } else {
                ans2[idx2++] = nums[i];
            }
        }
        
        idx2 = 0;
        for(; idx1<n; idx1++) {
            ans1[idx1] = ans2[idx2++];
        }
        
        return ans1;
    }
}