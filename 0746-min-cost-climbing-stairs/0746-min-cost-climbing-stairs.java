class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int totalSteps = cost.length;
        int prevCost2 = 0;
        int prevCost1 = cost[0];
      
        for(int i=2; i<=totalSteps; i++) {
            int curr = cost[i-1] + Math.min(prevCost2, prevCost1);
            prevCost2 = prevCost1;
            prevCost1 = curr;
        }

        return Math.min(prevCost2, prevCost1);
    }
}