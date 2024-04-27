class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        int n = points.length;
        int count = 1;
        int x1 = points[0][0];

        for(int i=1; i<n; i++) {
            int x2 = points[i][0];
            if(x2-x1 > w) {
                count++;
                x1 = x2;
            }
        }

        return count;
    }
}