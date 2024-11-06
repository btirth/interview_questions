class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[][] children = new int[n][2];
        int[] candies = new int[n];

        for(int i=0; i<n; i++) {
            children[i][0] = i;
            children[i][1] = ratings[i];
        }

        Arrays.sort(children, (a,b) -> Integer.compare(a[1], b[1]));
        for(int[] child: children) {
            int idx = child[0];
            int rating = child[1];
            int candiesForChild = 1;
            
            if(idx>0 && rating > ratings[idx-1]) {
                candiesForChild = Math.max(candiesForChild, candies[idx-1] + 1);
            }

            if(idx < n-1 && rating > ratings[idx+1]) {
                candiesForChild = Math.max(candiesForChild, candies[idx+1] + 1);
            }

            candies[idx] = candiesForChild;
        }

        int totalCandies = 0;

        for(int candy: candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}