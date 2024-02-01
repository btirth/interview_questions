class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if(n%3 != 0) {
            return new int[][]{};
        }
        Arrays.sort(nums);
        int[][] ans = new int[n/3][3];
        int idx = -1;
        int firstEle = -1;
        for(int i=0; i<n; i++) {
            if(i%3 == 0) {
                idx++;
                firstEle = nums[i];
            }

            if(nums[i] - firstEle > k ) {
                return new int[][]{};
            }
            ans[idx][i%3] = nums[i];
        }

        return ans;
    }
}