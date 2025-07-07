class Solution {
    public int maxEvents(int[][] events) {
        int count = 0;
        int time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        int idx = 0;
        int len = events.length;

        while(idx < len || !pq.isEmpty()) {
            while(pq.isEmpty() || (idx<len && events[idx][0] <= time)) {
                pq.add(events[idx]);
                time = Math.max(time, events[idx][0]);
                idx++;
            }

            while(!pq.isEmpty()) {
                int[] event = pq.poll();
                if(event[1] < time) {
                    continue;
                }

                time = Math.max(time + 1, event[0] + 1);
                count++;
                break;
            }
        }

        return count;
    }
}