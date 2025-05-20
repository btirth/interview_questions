class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        /**
        [4,3,2,1], queries = [[1,3],[0,2]]

        Let's see if we can apply line-sweap algorithm

        [4,3,2,1]
        [1,3] -> [0,1,0,-1]
        [0,2] -> [1,1,-1,-1]

        now I'll go from 0 -> 4 with prefix sum
        
         */

        int n = nums.length;
        int[] linesweap = new int[n + 1];

        for(int[] q: queries) {
            linesweap[q[0]]++;
            linesweap[q[1] + 1]--;
        } 

        int prefixSum = 0;
        for(int i=0; i<n; i++) {
            prefixSum += linesweap[i];

            if(prefixSum < nums[i]) {
                return false;
            }
        }

        return true;
    }
}