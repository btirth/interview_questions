class NumArray {
    int[] sum;
    int[] numsCopy;
    public NumArray(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return;
        }
        numsCopy = nums;
        sum = new int[len];
        sum[0] = nums[0];
        for(int i=1; i<len; i++) {        
            sum[i] = sum[i-1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i != 0) {
            return sum[j] - sum[i] + numsCopy[i];
        }
            return sum[j];
    }
}
