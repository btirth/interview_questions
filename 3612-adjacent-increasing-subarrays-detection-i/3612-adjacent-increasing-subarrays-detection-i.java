class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int aIdx = 0;
        int bIdx = k;
        if(k == 1) {
            return true;
        }
        while(bIdx <= nums.size()-k) {
            int aCurr = nums.get(aIdx);
            int bCurr = nums.get(bIdx);
            for(int i=1; i<k; i++) {
                int aVal = nums.get(aIdx + i);
                int bVal = nums.get(bIdx + i);

                if(aVal <= aCurr || bVal <= bCurr) {
                    aIdx += i;
                    bIdx = aIdx+k;
                    break;
                } 

                aCurr = aVal;
                bCurr = bVal;
                if(i == k-1) {
                    return true;
                }
            }
        }

        return false;
    }
}