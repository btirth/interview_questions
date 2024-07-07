class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;

        while(numBottles >= numExchange) {
            int exchangedBottles = numBottles / numExchange;
            int emptyBootles = exchangedBottles*numExchange;
            count += emptyBootles;
            numBottles -= emptyBootles;
            numBottles += exchangedBottles;
        }

        count += numBottles;
        return count;
    }
}