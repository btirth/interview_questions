class Solution {
    public String clearStars(String s) {
        /**
        
        We'll go from left to right
        -> Found *
            -> Delete right most smallest character from its left side.

        The question is how we keep track of right most smallest char.
        -> Stack
        -> Queue/Deque
        -> PriorityQueue -> This one makes more sense -> Mark the deleted idx    
        
         */

        int len = s.length();
        boolean[] include = new boolean[len];
        Arrays.fill(include, true);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(b[1],  a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        for(int i=0; i<len; i++) {
            if(s.charAt(i) == '*') {
                include[i] = false;
                int[] smallest = pq.poll();
                include[smallest[1]] = false;
            } else {
                pq.add(new int[]{s.charAt(i) - 'a', i});
            }
        } 

        StringBuilder res = new StringBuilder("");
        for(int i=0; i<len; i++) {
            if(include[i]) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}