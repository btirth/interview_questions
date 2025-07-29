class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] freq = new int[32];
        int len = nums.length;
        int left = len - 1;
        int[] ans = new int[len];

        for(int i=len-1; i>=0; i--) {
            updateFreq(freq, nums[i]);

            while(left > i && possibleRemoveLast(freq, nums[left])) {
                removeLast(freq, nums[left]);
                left--;
            }

            ans[i] = left - i + 1;
        }

        return ans;
    }

    void updateFreq(int[] freq, int num) {
        for(int i=0; i<32; i++) {
            if((num & (1 << i)) != 0) {
                freq[i]++;
            }
        }
    }

    void removeLast(int[] freq, int num) {
        for(int i=0; i<32; i++) {
            if((num & (1 << i)) != 0) {
                freq[i]--;
            }
        }
    }

    boolean possibleRemoveLast(int[] freq, int num) {
        for(int i=0; i<32; i++) {
            if((num & (1 << i)) != 0 && freq[i] == 1) {
                return false;
            }
        }

        return true;
    }
}