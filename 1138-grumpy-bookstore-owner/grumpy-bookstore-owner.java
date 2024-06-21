class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfiedCust = 0;
        int notSatisfiedCust = 0;
        int[] dp = new int[n];
        int maxSatisfiedCust = 0;

        for(int i=0; i<n; i++) {
            if(grumpy[i] == 1) {
                notSatisfiedCust += customers[i];                
            } else {
                satisfiedCust += customers[i];
            }
            dp[i] = notSatisfiedCust;
            if(i < minutes) {
                maxSatisfiedCust = Math.max(maxSatisfiedCust, notSatisfiedCust);
            } else {
                maxSatisfiedCust = Math.max(maxSatisfiedCust, notSatisfiedCust - dp[i-minutes]);
            }
            
        }

        return maxSatisfiedCust + satisfiedCust;
    }
}