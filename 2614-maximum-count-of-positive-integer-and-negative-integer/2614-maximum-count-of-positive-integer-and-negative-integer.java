class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int pos = findPos(nums);
        int neg = findNeg(nums) + 1;
        return Math.max(n - pos, neg);
    }

    int findNeg(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] < 0) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    int findPos(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] > 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;    
    }
}