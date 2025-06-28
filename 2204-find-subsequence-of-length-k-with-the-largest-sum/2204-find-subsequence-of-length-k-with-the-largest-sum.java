class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[k];
        int[][] ansIdx = new int[k][2];
        int[][] pair = new int[len][2];

        for(int i=0; i<len; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        for(int i=0; i<k; i++) {
            ansIdx[i][0] = pair[i][0];
            ansIdx[i][1] = pair[i][1];
        }

        Arrays.sort(ansIdx, (a,b) -> Integer.compare(a[1], b[1]));

        for(int i=0; i<k; i++) {
            ans[i] = ansIdx[i][0];
        }

        return ans;
    }
}