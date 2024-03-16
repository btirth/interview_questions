class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int cnt0= 0 ;
        int cnt1 = 0;
        HashMap<Integer, Integer> diff = new HashMap<>();
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                cnt0++;
            } else {
                cnt1++;
            }
            
            int d = cnt1-cnt0;
            if(d == 0) {
                ans = i+1;
            }
            if(diff.containsKey(d)) {
                int possibleAns = i - diff.get(d);
                ans = Math.max(ans, possibleAns);
            } else {
                diff.put(d, i);
            }
        }

        return ans;
    }
}