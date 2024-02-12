class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        int num = nums[0];

        for(int i=1; i<n; i++) {
            if(num == nums[i]) {
                count++;
            } else {
                count--;

                if(count == 0) {
                    num = nums[i];
                    count++;
                }
            }
        }

        return num;
    }
}