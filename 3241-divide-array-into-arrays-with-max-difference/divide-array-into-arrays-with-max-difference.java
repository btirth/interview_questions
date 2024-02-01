class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if(n%3 != 0) {
            return new int[][]{};
        }
        Arrays.sort(nums);
        int[][] ans = new int[n/3][3];
        int idx = 0;
        for(int i=0; i<n; i+=3) {
            int first = nums[i];
            int second = nums[i+1];
            int third = nums[i+2];

            if(third-first > k) {
                return new int[][]{};
            }

            ans[idx][0] = first;
            ans[idx][1] = second;
            ans[idx][2] = third;
            idx++;
        }

        return ans;
    }
}