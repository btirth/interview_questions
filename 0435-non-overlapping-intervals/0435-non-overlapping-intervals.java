class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /**
        If we sort based on end time, 
        so we will know if it ends before that's good so that there'll be less chance overlaping with the next one.

        
         */

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prev = -50000;

        for(int[] interval: intervals) {
            if(interval[0] < prev) {
                count++;
            } else {
                prev = interval[1];
            }
        }

        return count;
    }
}