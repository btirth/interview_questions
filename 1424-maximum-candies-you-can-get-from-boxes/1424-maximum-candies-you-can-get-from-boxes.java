class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        /**
        1. Add initial boxes
        2. for each box in Q
            -> if open add that box
                -> Add keys
                    -> If status is -1 that means already found but waiting for key, so add that back in Q
                    -> Mark status of that boxes as 1
                -> Add contained box
            -> if close 
                -> mark status as -1
        
         */
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int box: initialBoxes) {
            q.add(box);
        }

        while(!q.isEmpty()) {
            int box = q.poll();
            if(status[box] == 1) {
                ans += candies[box];

                for(int key: keys[box]) {
                    if(status[key] == 0) {
                        status[key] = 1;
                    } else if(status[key] == -1) {
                        status[key] = 1;
                        q.add(key);
                    }
                }

                for(int next: containedBoxes[box]) {
                    q.add(next);
                }

            } else {
                status[box] = -1;
            }
        }

        return ans;
    }
}