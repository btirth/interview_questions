class Solution {
    int[] bitFreq;
    int k;
    public int minimumSubarrayLength(int[] nums, int k) {
        // subarray -> first idea SLIDING WINDOW
        /*

            1 - 001
            2 - 010
        --------------
           OR - 011
            3 - 011
        --------------
           OR - 011
        REM 1 - is there binary opt to remove 1 from currentOR ??   I dont think so -> hashmap for bit index and freq of set value ? if set value == 0 after removing left pt -> make that bit 0 -> validate if the currOR will be still >= K if not dont remove it     

        */

        int minSubArrayLen = Integer.MAX_VALUE;
        bitFreq = new int[32];
        this.k = k;

        int left = 0;
        int right = 0;
        int n = nums.length;
        int currOr = 0;
        while(right < n) {
            add(nums[right]);
            currOr |= nums[right];
            while(left<=right && currOr >= k) {
                minSubArrayLen = Math.min(minSubArrayLen, right - left + 1);
                currOr = remove(nums[left]);
                left++;
            }
            
            right++;
        }

        return minSubArrayLen == Integer.MAX_VALUE ? -1 : minSubArrayLen;
    }

    void add(int num) {
        for(int i=0; i<32; i++) {
            if((num & (1<<i)) != 0) {
                bitFreq[i]++;
            }
        }
    }

    int remove(int num) {
        int res = 0;
        for(int i=0; i<32; i++) {
            if((num & (1<<i)) != 0) {
                bitFreq[i]--;
            }

            if(bitFreq[i] > 0) {
                res |= (1<<i);
            }
        }

        return res;
    }
}