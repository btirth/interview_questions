class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,  (a,b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int n = intervals.length;
        int count = 1;
        int highEnd = intervals[0][1];

        for(int i=1; i<n; i++) {
            if(intervals[i][1] > highEnd) {
                count++;
                highEnd = intervals[i][1];
            }
        }

        return count;
    }
}