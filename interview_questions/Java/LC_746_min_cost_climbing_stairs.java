/*

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
    Input: cost = [10, 15, 20]
    Output: 15
    Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

Example 2:
    Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
    Output: 6
    Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

Note:
    cost will have a length in the range [2, 1000].
    Every cost[i] will be an integer in the range [0, 999].

*/


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int minCost = Integer.MAX_VALUE;
        int[] d = new int[cost.length];
        for(int i=0; i<=1; i++) {
            minCost = Math.min(minCost, minCostStairs(cost, d, i));
        }
        
        return minCost;
    }
    
    int minCostStairs(int[] cost, int[] d, int idx) {
        if(idx >= d.length) {
            return 0;
        } 
        
        if(d[idx] != 0) {
            return d[idx];
        }
        
        int a = minCostStairs(cost, d, idx+1);
        int b = minCostStairs(cost, d, idx+2);
        
        int min_cost = cost[idx] + Math.min(a, b);
        d[idx] = min_cost;
        
        return min_cost;
    }
}