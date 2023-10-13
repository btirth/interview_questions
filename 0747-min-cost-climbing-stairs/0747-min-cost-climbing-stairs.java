class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int n1 = cost[n-1];
        int n2 = cost[n-2];

        for(int i=n-3; i>=0; i--) {
            int temp = cost[i] + Math.min(n1, n2);
            n1 = n2;
            n2 = temp;
        }

        return Math.min(n1, n2);
    }
}