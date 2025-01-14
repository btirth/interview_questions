class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean firstFound = false;

        for(int i=0; i<n; i++) {
            if(nums[i] == 1) {
                firstFound = true;
            }

            if(nums[i] < 1) {
                nums[i] = 1;
            }
        }

        if(!firstFound) {
            return 1;
        }

        for(int i=0; i<n; i++) {
            int val = Math.abs(nums[i]);
            if(val < n) {
                if(nums[val] < 0) {
                    continue;
                }

                nums[val] *= -1; 
            }
        }

        int ans = n;
        for(int i=2; i<n; i++) {
            if(nums[i] > 0) {
                ans = i;
                break;
            }
        }

        for(int i=0; i<n; i++) {
            if(Math.abs(nums[i]) == ans) {
                return ans + 1;
            }
        }

        return ans;
    }
}