class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int prevEnd = Integer.MIN_VALUE;
        for(int[] interval: intervals) {
            if(interval[0] < prevEnd) {
                count++;
                prevEnd = Math.min(interval[1], prevEnd);
            } else {
                prevEnd = interval[1];
            }
        }

        return count;
    }
}