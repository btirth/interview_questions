class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int lcs = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(set.contains(nums[i] + 1)) {
                continue;
            }   

            int count = 1;
            while(set.contains(nums[i] - count)) {
                count++;
            }

            lcs = Math.max(lcs, count);
        }

        return lcs;
    }
}