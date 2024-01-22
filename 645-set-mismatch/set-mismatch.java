class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(ans[0]==0 && nums[num-1] < 0) {
                ans[0] = num;
            } else {
                nums[num-1] *= -1;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                ans[1] = i+1;
                break;
            }
        }

        return ans;
    }
}