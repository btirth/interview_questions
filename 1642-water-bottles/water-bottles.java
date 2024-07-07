class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;

        while(numBottles >= numExchange) {
            count += numExchange;
            numBottles -= numExchange;
            numBottles++;
        }

        count += numBottles;
        return count;
    }
}