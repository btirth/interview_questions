class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = null;
        List<int[]> res = new ArrayList<>();
        for(int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            if(prev != null && prev[1] >= interval[0]) {
                res.remove(res.size()-1);
                start = Math.min(prev[0], interval[0]);
                end = Math.max(prev[1], interval[1]);
            }

            res.add(prev = new int[]{start, end});
        }

        // convert list into array.
        int[][] ans = new int[res.size()][];
        for(int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}