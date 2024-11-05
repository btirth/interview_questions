class Solution {
    class Point implements Comparable<Point>{
        double dist;
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = Math.pow(x*x + y*y, 0.5);
        }

        public int compareTo(Point p) {
            return Double.compare(this.dist, p.dist);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(k);
        int[][] closestPoints = new int[k][2];

        for(int[] point: points) {
            pq.add(new Point(point[0], point[1]));
        }


        int idx = 0;
        while(!pq.isEmpty() && idx < k) {
            Point point = pq.poll();
            closestPoints[idx][0] = point.x;
            closestPoints[idx][1] = point.y;
            idx++;
        }
        return closestPoints;
    }
}