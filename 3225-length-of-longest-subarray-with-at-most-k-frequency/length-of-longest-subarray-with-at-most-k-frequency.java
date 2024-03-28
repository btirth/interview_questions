class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int l = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<n; i++) {
            int f = freq.getOrDefault(nums[i], 0);

            if(f >= k) {
                while(l<=i) {
                    freq.put(nums[l], freq.get(nums[l])-1);
                    if(nums[l] == nums[i]) {
                        l++;
                        break;
                    }
                    l++;
                }
            }
            
            ans = Math.max(ans, i-l+1);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }

        return ans;
    }
}