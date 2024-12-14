class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        /**
        
            keep track of total diff till you reach building 'i'
            if total diff > bricks that means you can't move forward and you'll need to use a ladder
            use heap to get maximum diff to use it for ladder
            add that diff back bricks (minus from total diff)

            if(diff > bricks && ladders == 0) {
                return
            }
        
        
         */
        int totalDiff = 0;
        int n = heights.length;
        PriorityQueue<Integer> diffForLadders = new PriorityQueue<>(Collections.reverseOrder());
        int prev = heights[0];
        int i = 1;
        for(; i<n; i++) {
            if(heights[i] <= heights[i-1]) {
                prev = heights[i];
                continue;
            }

            int diff = heights[i] - heights[i-1];
            totalDiff += diff;
            diffForLadders.add(diff);

            while(!diffForLadders.isEmpty() && totalDiff > bricks && ladders > 0) {
                totalDiff -= diffForLadders.poll();
                ladders--;
            } 

            if(totalDiff > bricks) {
                break;
            }

            prev = heights[i];
        }

        return i-1;
    }
}