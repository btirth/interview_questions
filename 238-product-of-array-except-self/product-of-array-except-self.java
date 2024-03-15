class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        boolean containsZero = false;
        int zeroIdx = -1;
        int prod = 1;
        for(int i=0; i<n; i++) {
            left[i] = prod;
            if(nums[i] != 0) {
                prod *= nums[i];
            } else {
                if(containsZero) {
                    return new int[n];
                }

                containsZero = true;
                zeroIdx = i;
            }
        }

        if(containsZero) {
            nums = new int[n];
            nums[zeroIdx] = prod;
            return nums;
        }

        int rightProd = 1;
        int temp = -1;
        for(int i=n-1; i>=1; i--) {
            temp = nums[i];
            nums[i] = rightProd * left[i];
            rightProd *= temp;
        }
        nums[0] = rightProd;
        return nums;
    }
}