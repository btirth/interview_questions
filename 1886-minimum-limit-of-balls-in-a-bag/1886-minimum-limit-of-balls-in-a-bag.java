class Solution {
    
    public int minimumSize(int[] nums, int maxOperations) {
        // Binary Search
        Arrays.sort(nums);
        int len = nums.length;
        int left = 1;
        int right = nums[len - 1];
        int ans = nums[len - 1];

        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(nums, mid, maxOperations)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int[] nums, int target, int maxOps) {
        int len = nums.length;
        for(int i=len - 1; i>=0; i--) {
            int val = nums[i];
            if(val > target) {
                maxOps -= (val / target) - 1;
                if(val%target > 0) {
                    maxOps--;
                }
                
                if(maxOps < 0) {
                    return false;
                }
            } else {
                break;
            }
        }

        return true;
    }
}