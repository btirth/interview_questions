class Solution {
    public int findMin(int[] nums) {

        /**
        
        high -> peak -> low

        mid 

        if(nums[right] < mid) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }   
        
         */
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = (right + left) / 2;

            ans = Math.min(ans, nums[mid]);
            if(nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}