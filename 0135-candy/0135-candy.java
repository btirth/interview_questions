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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        for(int i=0; i<n; i++) {
            pq.add(new int[]{ratings[i], i});
        }


        int[] candies = new int[n];
        while(!pq.isEmpty()) {
            int[] pt = pq.poll();
            int idx = pt[1];
            int val = 0;
            if(idx > 0 && ratings[idx] > ratings[idx-1]) {
                val = Math.max(val, candies[idx-1]);
            }

            if(idx < n-1 && ratings[idx] > ratings[idx+1]) {
                val = Math.max(val, candies[idx+1]);
            }

            candies[idx] = val + 1;
        }


        int totalCandies = 0;
        for(int candy: candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}