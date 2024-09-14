class Solution {
    public int longestSubarray(int[] nums) {
        int maxAnd = 0;
        int left = 0;
        int right = 0;
        int currAnd = 0;
        int longestSubArrayLength = 0;
        int n = nums.length;

        while(right < n) {  
            int newAnd = nums[right] & currAnd;
            if(newAnd < nums[right]) {
                currAnd = nums[right];
                left = right;
            } else {
                currAnd = newAnd;
            }
            
            if(currAnd > maxAnd) {
                maxAnd = currAnd;
                longestSubArrayLength = right - left + 1;
            }

            if(currAnd == maxAnd) {
                longestSubArrayLength = Math.max(longestSubArrayLength, right - left + 1);
            }

            right++;
        }

        return longestSubArrayLength;
    }
}