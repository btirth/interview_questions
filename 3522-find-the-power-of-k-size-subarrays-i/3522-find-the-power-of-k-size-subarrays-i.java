class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Arrays.fill(ans, -1);
        int lastMisMatch = -1;
        int[] maxTrack = new int[n];
        int maxTrackEndIdx = 0;
        int maxTrackStartIdx = 0;
        for(int i=0; i<n; i++) {
            if(i>=k && maxTrack[maxTrackStartIdx] == nums[i-k]) {
                maxTrackStartIdx++;
            }

            while(maxTrackEndIdx>maxTrackStartIdx && maxTrack[maxTrackEndIdx] < nums[i]) {
                maxTrackEndIdx--;
            }

            maxTrack[maxTrackEndIdx++] = nums[i];

            if(i != 0 && nums[i] != nums[i-1] + 1) {
                lastMisMatch = i-1;
            }

            if(lastMisMatch < i-k+1 && i>=k-1) {
                ans[i-k+1] = maxTrack[maxTrackStartIdx];
            }
        }

        return ans;
    }
}