class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a,b) -> Double.compare(b.getKey(), a.getKey()));
        for(int i=0; i<n; i++) {
            double currRatio = ((double)classes[i][0] / (double)classes[i][1]);
            double nextRatio = ((double)(classes[i][0]+1.0) / (double)(classes[i][1]+1.0));
            pq.add(new Pair(nextRatio - currRatio, i));
        }

        while(extraStudents-- > 0) {
            Pair p = pq.poll();
            int idx = (int)p.getValue();
            classes[idx][0] += 1;
            classes[idx][1] += 1;
            double currRatio = ((double)classes[idx][0] / (double)classes[idx][1]);
            double nextRatio = ((double)(classes[idx][0]+1.0) / (double)(classes[idx][1]+1.0));
            pq.add(new Pair(nextRatio - currRatio, idx));
        }

        double total = 0.0;

        for(int i=0; i<n; i++) {
            total += ((double)classes[i][0] / (double)classes[i][1]);
        }

        return total/n;
    }
}