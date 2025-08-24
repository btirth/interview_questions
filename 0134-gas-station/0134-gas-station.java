class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /**
        Goal is to find the starting gas station such that I can travel around the circuit

        I can only start at gas station i if from that point I can travel around the circuit.
        So that means the point where I don't have enough gas to move to the next points, all the points before that points aren't the ans. So I'll again try from the next point. 
        
         */

        int totalStations = gas.length;
        int currStation = 0;
        int startPoint = 0;
        int remainingGas = 0;

        while(currStation < totalStations) {
            remainingGas += gas[currStation];
            remainingGas -= cost[currStation];

            if(remainingGas < 0) {
                startPoint = currStation + 1;
                remainingGas = 0;
            } 

            currStation++;
        }

        for(int i=0; i<startPoint; i++) {
            remainingGas += gas[i];
            remainingGas -= cost[i];

            if(remainingGas < 0) {
                return -1;
            }
        }

        return startPoint;
    }
}