class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        long sum = nums[0] + nums[1];
        long ans = -1;

        for(int i=2; i<n; i++) {
            sum += nums[i];
            if(sum > nums[i]*2) {
                ans = Math.max(ans, sum);
            }    
        }

        return ans;
    }
}