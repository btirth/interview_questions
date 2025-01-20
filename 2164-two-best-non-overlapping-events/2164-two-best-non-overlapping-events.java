class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int[][] start = new int[n][2];
        int[][] end = new int[n][2];

        for(int i=0; i<n; i++) {
            start[i][0] = events[i][0];
            start[i][1] = events[i][2];
            end[i][0] = events[i][1];
            end[i][1] = events[i][2];
        }

        Arrays.sort(start, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(end, (a,b) -> Integer.compare(a[0], b[0]));

        int startIdx = 0;
        int endIdx = 0;

        int maxValue = 0;
        int ans = 0;

        while(startIdx < n) {
            while(endIdx < n & end[endIdx][0] < start[startIdx][0]) {
                maxValue = Math.max(maxValue, end[endIdx][1]);
                endIdx++;
            }

            ans = Math.max(ans, maxValue + start[startIdx][1]);
            startIdx++;
        }

        return ans;
    }
}