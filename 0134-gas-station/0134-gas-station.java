class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(!isPossible(gas, cost)) {
            return -1;
        }

        int sum = 0;
        int firstAddIdx = 0;

        for(int i=0; i<gas.length; i++) {
            if(gas[i]-cost[i] >= 0 && sum == 0) {
                firstAddIdx = i;
            }
            sum += (gas[i]-cost[i]);
            sum = Math.max(sum, 0);
        }

        return firstAddIdx;
    }

    boolean isPossible(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for(int i=0; i<gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        return totalGas >= totalCost;
    }
}