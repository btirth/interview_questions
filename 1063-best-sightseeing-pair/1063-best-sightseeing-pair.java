class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        /**
            Can I be greedy and 2 pointer approach?
            [8,1,5,2,6] i=0, j=4 -> 8+6+0-4 = 10
            6 is smaller so reduce it
            i = 0, j=3 -> 8 + 2 + 0 - 3 = 7
            i = 0, j=2 -> 8 + 5 + 0 - 2 = 11
            i = 0, j=1
            O(n)

            DP -> O(n^2)




            Max((values[i] + i) + (values[j] - j))
            what if I keep track of maximum of (values[i] + i) and calculate (values[j] - j) as I go
         */


         int maxFirstPart = values[0];
         int ans = 0;
         int n = values.length;
         for(int i=1; i<n; i++) {
            ans = Math.max(ans, maxFirstPart + values[i] - i);
            maxFirstPart = Math.max(maxFirstPart, values[i] + i);
         }

         return ans;
    }
}