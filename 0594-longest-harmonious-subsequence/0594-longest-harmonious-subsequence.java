class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int count1 = 0;
        int count2 = 1;
        int ans = 0;
        int len = nums.length;
        
        for(int i=1; i<len; i++) {
            if(nums[i] != nums[i-1]) {
                if(count1 != 0 && count2 != 0) {
                    ans = Math.max(count1 + count2, ans);
                }
                
                if(nums[i] - nums[i-1] != 1) {
                    count2 = 0;
                }

                count1 = count2;
                count2 = 0;
            }

            count2++;
        }

        if(count1 != 0 && count2 != 0) {
            ans = Math.max(count1 + count2, ans);
        }
        return ans;
    }
}