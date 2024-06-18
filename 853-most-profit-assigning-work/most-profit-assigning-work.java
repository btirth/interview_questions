class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] task = new int[n][2];
        int totalProfit = 0;
        int maxProfit = 0;

        for(int i=0; i<n; i++) {
            task[i][0] = difficulty[i];
            task[i][1] = profit[i];
        }

        Arrays.sort(task, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(worker);
        int taskIdx = 0;
        for(int w: worker) {
            while(taskIdx < n && task[taskIdx][0] <= w) {
                maxProfit = Math.max(maxProfit, task[taskIdx][1]);
                taskIdx++;
            }
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}