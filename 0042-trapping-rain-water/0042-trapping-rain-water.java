class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;

        for(int i=0; i<n; i++) {
            left[i] = max;
            max = Math.max(max, height[i]);
        }

        max = 0;
        for(int i=n-1; i>=0; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }

        int totalWater = 0;
        for(int i=1; i<n-1; i++) {
            totalWater += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }

        return totalWater;
    }
}