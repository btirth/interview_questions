class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 1;
        int right = 0;

        for(int num: nums) {
            left = Math.max(num, left);
            right += num;
        }

        int ans = 0;
        while(left <= right) {
            int mid = (right + left) / 2;
            int partition = countPartition(nums, mid);

            if(partition > k) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;
    }

    int countPartition(int[] nums, int max) {
        int currSum = 0;
        int partitions = 1;

        for(int i=0; i<nums.length; i++) {
            if(currSum + nums[i] > max) {
                partitions++;
                currSum = 0;
            } 

            currSum += nums[i];
        }

        return partitions;
    }
}