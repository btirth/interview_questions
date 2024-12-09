class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int currIdx = 0;
        int n = nums.length;

        if(n == 1) {
            return 0;
        }

        while(currIdx < n) {
            int nextJump = -1;
            if(currIdx + nums[currIdx] >= n-1) {
                count++;
                break;
            }

            for(int i=currIdx + 1; i<n && i<=currIdx + nums[currIdx]; i++) {
                if(nextJump == -1 || i+nums[i] >= nextJump + nums[nextJump]) {
                    nextJump = i;
                }
            }

            currIdx = nextJump;
            count++;
        }

        return count;
    }
}