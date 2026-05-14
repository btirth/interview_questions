class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int ans = nums[0];

        for(int num: nums) {
            int tempMax = max;
            
            max = Math.max(max * num, min * num);
            max = Math.max(max, num);
            min = Math.min(min * num, tempMax * num);
            min = Math.min(min, num);

            ans = Math.max(ans, Math.max(max, min));

            if(num == 0) {
                max = 1;
                min = 1;
            }
        }

        return ans;
    }
}