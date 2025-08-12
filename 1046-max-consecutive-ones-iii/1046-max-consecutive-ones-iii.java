class Solution {
    public int longestOnes(int[] nums, int k) {
        /**
        max number of consecutive 1's

        can I say res = no. of 1's + no. of 0's < k
        if use 2 pointers 
        -> If nums[idx] == 1
            right++
           else:
            while cnt >= k:
                // move left pointer
                if nums[left] == 0
                    cnt--;
                
                left++;

           ans = max(ans, right - left + 1)      
        
        [1,0,0,0,1,1,1], k = 2
        [1,0,0] = 3
        [0,0]
        []
    
         */

        int left = 0;
        int right = 0;
        int len = nums.length;
        int flipped = 0;
        int ans = 0;

        while(right < len) {
            if(nums[right] == 0) {
                while(left <= right && flipped >= k) {
                    if(nums[left] == 0) {
                        flipped--;
                    }

                    left++;
                }        

                flipped++;
            } 

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}