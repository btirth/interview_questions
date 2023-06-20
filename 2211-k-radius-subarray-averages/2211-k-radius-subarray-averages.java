class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        if(n < (2*k+1)) {
            return ans;
        }

        int left = 0;
        int right = 2*k;
        long sum = 0;

        for(int i=0; i<2*k; i++) {
            sum += nums[i];
        }

        for(int i=k; i<n-k; i++) {
            sum += nums[right];
            right++;

            ans[i] = (int)(sum/(2*k+1));

            sum -= nums[left];
            left++;
        }

        return ans;
    }
}