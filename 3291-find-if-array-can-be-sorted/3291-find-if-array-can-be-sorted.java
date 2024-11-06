class Solution {
    public boolean canSortArray(int[] nums) {
        HashMap<Integer, Integer> setBitsMap = new HashMap<>();
        for(int num: nums) {
            setBitsMap.put(num, getSetBits(num));
        }
        int n = nums.length;
        for(int i=0; i<n; i++) {
            boolean needAnotherRound = false;
            for(int j=1; j<n; j++) {
                if(nums[j] < nums[j-1]) {
                    if(setBitsMap.get(nums[j]) == setBitsMap.get(nums[j-1])) {
                        int temp = nums[j-1];
                        nums[j-1] = nums[j];
                        nums[j] = temp;
                    } 

                    needAnotherRound = true;
                }
            }

            if(!needAnotherRound) {
                return true;
            }
        }

        for(int i=1; i<n; i++) {
            if(nums[i] < nums[i-1]) {
                return false;
            }
        }

        return true;
    }

    int getSetBits(int num) {
        int setBits = 0;
        int bit = 1;
        for(int i=0; i<=8; i++) {
            if((int)(num & bit) > 0) {
                setBits++;
            }

            bit = bit << 1;
        }

        return setBits;
    }
}