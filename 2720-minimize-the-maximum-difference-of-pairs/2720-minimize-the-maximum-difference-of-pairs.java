class Solution {
    public int minimizeMax(int[] nums, int p) {
        /**
        If we sort the array

        Our goal is to find maximum diff minimum
        if we sort the array and take the diff of 2 pairs and find pth max.

        If we pick the smallest diff and mark it's idx if already isn't marked
        
        [4,2,1,2]
        [1,2,2,4]

        We can apply binary search, and each time count the diff
         */
        int n = nums.length; 
        Arrays.sort(nums);
        int l = 0;
        int r = nums[n - 1] - nums[0];
        int ans = 0;
        while(l <= r) {
            int mid = (r + l) / 2;
            if(isPossible(nums, mid, p)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int[] nums, int maxDiff, int p) {
        int count = 0;
        int n = nums.length;
        int prev = -1;
        for(int i=0; i<n; i++) {
            if(prev == -1) {
                prev = nums[i];
            } else {
                if(Math.abs(prev - nums[i]) <= maxDiff) {
                    count++;
                    prev = -1;

                    if(count == p) {
                        return true;
                    }
                } else {
                    prev = nums[i];
                }
            }


        }

        return false;
    }
}