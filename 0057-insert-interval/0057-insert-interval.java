class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer[]> finalIntervals = new ArrayList<>();
        int n = intervals.length;
        if(n == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        int start = intervals[0][0];
        int end = intervals[0][1];
        boolean isAdded = false;
        for(int i=1; i<n; i++) {

            if(!isAdded && newInterval[0] <= start) {
                if(newInterval[1] < start) {
                    finalIntervals.add(new Integer[]{newInterval[0], newInterval[1]});
                } else {
                    start = Math.min(start, newInterval[0]);
                    end = Math.max(end, newInterval[1]);
                }
                isAdded = true;
            }

            if(!isAdded && newInterval[0] <= end) {
                end = Math.max(end, newInterval[1]);
                isAdded = true;
            }

            if(intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                finalIntervals.add(new Integer[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }


        if(!isAdded && newInterval[0] <= start) {
            if(newInterval[1] < start) {
                finalIntervals.add(new Integer[]{newInterval[0], newInterval[1]});
            } else {
                start = Math.min(start, newInterval[0]);
                end = Math.max(end, newInterval[1]);
            }
            isAdded = true;
        }

        if(!isAdded && newInterval[0] <= end) {
            end = Math.max(end, newInterval[1]);
            isAdded = true;
        }

        finalIntervals.add(new Integer[]{start, end});

        if(!isAdded) {
            finalIntervals.add(new Integer[]{newInterval[0], newInterval[1]});
        }

        // Convert into array
        int totalIntervals = finalIntervals.size();
        int[][] ans = new int[totalIntervals][2];
        int idx = 0;
        for(Integer[] interval: finalIntervals) {
            ans[idx][0] = (int)interval[0];
            ans[idx][1] = (int)interval[1];

            idx++;
        }

        return ans;
    }
}