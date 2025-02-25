class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int maxPro = 1;
        int minPro = 1;

        for(int num: nums) {
            if(num == 0) {
                maxPro = 1;
                minPro = 1;
            } 

            int temp = Math.min(num, Math.min(minPro * num, maxPro * num));
            maxPro = Math.max(num, Math.max(maxPro * num, minPro * num));
            minPro = temp;
            ans = Math.max(ans, Math.max(minPro, maxPro));
        }

        return ans;
    }
}