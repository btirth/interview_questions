class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0;
        int neg = 0;
        boolean posTurn = true;
        for(int i=0; i<n; i++) {
            if(posTurn) {
                while(nums[pos] < 0) {
                    pos++;
                }

                ans[i] = nums[pos];
                pos++;
                posTurn = false;
            } else {
                while(nums[neg] > 0) {
                    neg++;
                }

                ans[i] = nums[neg];
                neg++;
                posTurn = true;
            }
        }

        return ans;
    }
}