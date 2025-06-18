class Solution {
    public int[][] divideArray(int[] nums, int k) {
        /**
        The main goal is to find array [a,b,c] -> We worry about a and c -> min and max
        1st thing we'll have to do sorting

        Then for each a -> find c, can we use binary search, find right most element which satisfy ? -> One of the options        

        or we can do that in reverse as well.

        Kind of bs and greedy

        [1,1,3,3,4,5,7,8,9]
        [1,1,3] []

        [2,2,2,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ] 
         */

        int n = nums.length;
        Arrays.sort(nums);
        int resN = n / 3;
        int[][] ans = new int[resN][3]; 
        int idx = 0;

        for(int i=0; i<resN; i++) {
            ans[i][0] = nums[idx++];
            ans[i][1] = nums[idx++];
            ans[i][2] = nums[idx++];

            if(ans[i][2] - ans[i][0] > k) {
                return new int[][]{}; 
            }
        }

        return ans;
    }
}