class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int qLen = queries.length;
        int[] ans = new int[qLen];

        for(int i=0; i<qLen; i++) {
            ans[i] = queries[i];
        }
        
        Arrays.sort(queries);
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        int idx = 0;
        for(int q: queries) {
            while(idx < n && intervals[idx][0] <= q) {
                pq.add(new int[]{intervals[idx][1] - intervals[idx][0] + 1, intervals[idx][1]});
                idx++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            int res = -1;
            if(!pq.isEmpty()) {
                res = pq.peek()[0];
            }

            map.put(q, res);
        }

        for(int i=0; i<qLen; i++) {
            ans[i] = map.get(ans[i]);
        }

        return ans;
    }
}