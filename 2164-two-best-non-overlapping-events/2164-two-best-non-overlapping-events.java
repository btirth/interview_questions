class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int[][] start = new int[n][2];
        int[][] endVal = new int[n][2];

        for(int i=0; i<n; i++) {
            start[i][0] = events[i][0];
            start[i][1] = events[i][2];
            endVal[i][0] = events[i][1];
            endVal[i][1] = events[i][2];
        }

        Arrays.sort(start, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(endVal, (a,b) -> Integer.compare(a[0], b[0]));

        int maxVal = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            while(idx<n && endVal[idx][0] < start[i][0]) {
                pq.add(endVal[idx][1]);
                idx++;
            }

            if(!pq.isEmpty()) {
                maxVal = Math.max(maxVal, start[i][1] + pq.peek());
            }

            maxVal = Math.max(maxVal, start[i][1]);
        }

        return maxVal;
    }
}