class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        long sum = nums[0] + nums[1];
        long ans = -1;
        int l = 0;
        for(int i=2; i<n; i++) {
            
            sum += nums[i];
            if(i-l >= 2 && sum-nums[i] > nums[i]) {
                ans = Math.max(ans, sum);
            }
            
        }

        return ans;
    }
}