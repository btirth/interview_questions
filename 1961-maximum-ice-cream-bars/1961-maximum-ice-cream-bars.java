class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int idx = 0;

        while(idx < costs.length && coins >= costs[idx]) {
            coins -= costs[idx];
            idx++;
        }

        return idx;
    }
}