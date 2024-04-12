class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        int ans = 0;
        left[0] = 0;
        right[n-1] = 0;

        for(int i=1; i<n; i++) {
            left[i] = max;
            if(height[i] >= height[max]) {
                max = i;
            }
        }

        max = n-1;
        for(int i=n-2; i>=0; i--) {
            right[i] = max;
            if(height[i] >= height[max]) {
                max = i;
            }
        }

        for(int i=1; i<n-1; i++) {
            int trappedWater = Math.min(height[left[i]], height[right[i]]) - height[i];
            if(trappedWater > 0) {
                ans += trappedWater;
            }
        }

        return ans;
    }
}