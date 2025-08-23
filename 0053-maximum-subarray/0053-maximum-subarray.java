class Solution {
    public int maxSubArray(int[] nums) {
        /**
        If sum goes < 0 -> forget about sum
        If sum < num -> isn't it better to just take num as new sum?
        
         */
        // int maxSum = nums[0];
        // int sum = 0;

        // for(int num: nums) {
        //     sum = Math.max(num, sum + num);
        //     maxSum = Math.max(maxSum, sum);
        // }

        // return maxSum;



        /*

            Divide and conquer approach
            -> LeftSum + curr + rightSum or leftSum or rightSum


            [5,4,-1,7,8]

            9, 9-1+15, 15



            [-2,1,-3,4,-1,2,1,-5,4]
            mid =-1, 

        */
        return divideAndConquer(nums, 0, nums.length-1);
    }


    int divideAndConquer(int[] nums, int l, int r) {
        if(l == r) {
            return nums[l];
        } else if(r < l) {
            return Integer.MIN_VALUE;
        }
        int mid = (l + r) / 2;
        int leftSum = 0;
        int rightSum = 0;
        int currSum = 0;

        for(int i=mid-1; i >= l; i--) {
            currSum += nums[i];
            leftSum = Math.max(leftSum, currSum);
        }

        currSum = 0;
        for(int i=mid+1; i<=r; i++) {
            currSum += nums[i];
            rightSum = Math.max(rightSum, currSum);
        }

        return Math.max(leftSum + nums[mid] + rightSum, Math.max(divideAndConquer(nums, l, mid-1), divideAndConquer(nums, mid+1, r)));
    }
}