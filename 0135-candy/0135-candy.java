class Solution {
    public int candy(int[] ratings) {
        /**
        
        [1,0,2]
        for 0 -> [1,1,2]
        for 1 -> [1,1,2]
        for 2 -> [1,1,2]


        [1,2,2]
        for 1 -> [1,2,0]
        for 2 -> [1,2,2]

        [4,2,1,2,4] 
        for 1 -> [0,2,1,2,0]
        for 2 -> [3,2,1,2,3]

        can I say that first give candies to children with lower candies
        give they do not have candy give 1 to them
        if()
        if(ratings[neighbors] > ratings[curr])
            give their neighbors = Math.max(existing[neighbors], 1 + curr children's)
        
         */


        int n = ratings.length;
        int[][] children = new int[n][2];
        int[] candies = new int[n];

        for(int i=0; i<n; i++) {
            children[i][0] = ratings[i];
            children[i][1] = i;
        }

        Arrays.sort(children, (a,b) -> Integer.compare(a[0], b[0]));
        
        for(int i=0; i<n; i++) {
            int rating = children[i][0];
            int idx = children[i][1];

            if(candies[idx] == 0) {
                candies[idx] = 1;
            }

            if(idx > 0 && ratings[idx-1] > ratings[idx]) {
                candies[idx-1] = Math.max(candies[idx-1], 1 + candies[idx]);
            }

            if(idx < n-1 && ratings[idx+1] > ratings[idx]) {
                candies[idx+1] = Math.max(candies[idx+1], 1 + candies[idx]);
            }
        }

        int totalCandies = 0;
        for(int candy: candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}