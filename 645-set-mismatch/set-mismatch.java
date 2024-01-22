class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = (n*(n+1))/2;
        int[] ans = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num-1] < 0) {
                ans[0] = num;
            } else {
                sum -= num;
                nums[num-1] *= -1;
            }
        }

        ans[1] = sum;
        return ans;
    }
}