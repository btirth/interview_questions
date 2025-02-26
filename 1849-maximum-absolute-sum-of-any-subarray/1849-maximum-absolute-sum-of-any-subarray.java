class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = 0;
        int max = 0;
        int ans = 0;

        for(int num: nums) {
            min += num;
            max += num;

            if(min > 0) {
                min = 0;
            } 

            if(max < 0) {
                max = 0;
            }

            ans = Math.max(ans, Math.max(Math.abs(min), max));
        }

        return ans;
    }
}