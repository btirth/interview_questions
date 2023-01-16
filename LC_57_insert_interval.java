/*

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:
  Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
  Output: [[1,5],[6,9]]

Example 2:
  Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
  Output: [[1,2],[3,10],[12,16]]
  Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 
Constraints:
  0 <= intervals.length <= 10^4
  intervals[i].length == 2
  0 <= starti <= endi <= 10^5
  intervals is sorted by starti in ascending order.
  newInterval.length == 2
  0 <= start <= end <= 10^5

*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] merged = new int[] {newInterval[0], newInterval[1]};
        boolean isInserted = false;

        for (int[] interval : intervals) {
            if(interval[0] > merged[1]) {
                if(!isInserted) {
                    mergedIntervals.add(merged);
                    isInserted = true;
                }
                mergedIntervals.add(interval);
                
            } else {
                // does intersect
                if(doesIntersect(merged, interval)) {
                    merged[0] = Math.min(merged[0], interval[0]);
                    merged[1] = Math.max(merged[1], interval[1]);
                } else {
                    // not intersecting
                    mergedIntervals.add(interval);
                }
                
                
            }
        }

        // new interval is at the end
        if(!isInserted) {
            mergedIntervals.add(merged);
            isInserted = true;
        }

        // Java specific to copy to arr[][]...
        int[][] res = new int[mergedIntervals.size()][2];
        for(int i = 0; i < mergedIntervals.size(); i++) {
            res[i] = mergedIntervals.get(i);
        }
        return res;

    }

    private boolean doesIntersect(int[] intervalA, int[] intervalB) {
        return intervalA[0] <= intervalB[1] && intervalB[0] <= intervalA[1];
    }
}
