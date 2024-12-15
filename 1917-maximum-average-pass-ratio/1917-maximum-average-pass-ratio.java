class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a,b) -> Double.compare(b.getKey(), a.getKey()));
        
        for(int i=0; i<n; i++) {
            pq.add(new Pair(getCurrAndNextRatioDiff(classes[i][0], classes[i][1]), i));
        }

        while(extraStudents-- > 0) {
            Pair p = pq.poll();
            int idx = (int)p.getValue();
            classes[idx][0] += 1;
            classes[idx][1] += 1;
            pq.add(new Pair(getCurrAndNextRatioDiff(classes[idx][0], classes[idx][1]), idx));
        }

        double total = 0.0;
        
        for(int i=0; i<n; i++) {
            total += ((double)classes[i][0] / (double)classes[i][1]);
        }

        return total/n;
    }

    double getCurrAndNextRatioDiff(int pass, int totalStudents) {
        double currRatio = ((double)pass / (double)totalStudents);
        double nextRatio = ((double)(pass+1.0) / (double)(totalStudents+1.0));
        return nextRatio - currRatio;
    }
}