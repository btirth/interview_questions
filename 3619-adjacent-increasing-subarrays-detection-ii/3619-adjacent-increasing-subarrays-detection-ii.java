class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] left = new int[n];
        int[] right = new int[n];
        int count = 1;

        left[0] = count;
        for(int i=1; i<n; i++) {
            if(nums.get(i-1) < nums.get(i)) {
                count++;
            }  else {
                count = 1;
            }
        
            left[i] = count;
        }

        count = 1;
        right[n-1] = count;
        for(int i=n-2; i>=0; i--) {
            if(nums.get(i+1) > nums.get(i)) {
                count++;
            }  else {
                count = 1;
            }
        
            right[i] = count;
        }

        int max = 0;
        for(int i=1; i<n; i++) {
            max = Math.max(max, Math.min(left[i-1], right[i]));
        }

        return max;
    }
}