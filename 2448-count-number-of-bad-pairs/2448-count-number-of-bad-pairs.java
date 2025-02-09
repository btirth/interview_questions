class Solution {
    public long countBadPairs(int[] nums) {
        /**
        We don't want 
        j - i == nums[j] - nums[i]
        
        That means nums[j] = j and nums[i] = i

        If we can find total number of index such as 
            nums[i] = i

        [1] -> 0
        [1,2] -> 1
        [1,2,3] -> [1,2][1,3][2,3]
        [1,2,3,4] -> [1,2][1,3][1,4][2,3][2,4][3,4]    
        Total no. of pairs = (n*(n-1)) / 2;

        if no. of nums[i] == i  is t
        ans = ((n*(n-1)) / 2) - ((t*(t-1)) / 2)
         */

        HashMap<Integer, Integer> diffFreq = new HashMap<>();
        int n = nums.length;
        long badPairs = 0;

        for(int i=0; i<n; i++) {
            int diff = nums[i] - i;
            int goodPairs = diffFreq.getOrDefault(diff, 0);

            badPairs += (i - goodPairs);
            diffFreq.put(diff, goodPairs + 1);
        }

        return badPairs;         
    }
}