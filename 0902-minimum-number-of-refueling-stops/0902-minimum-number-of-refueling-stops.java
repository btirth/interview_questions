class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int availableFuel = startFuel;
        int stationIdx = 0;
        int currentPosition = 0;
        int count = 0;
        Arrays.sort(stations, (a,b) -> Integer.compare(a[0], b[0]));

        while(target > currentPosition && stationIdx < stations.length) {
            while(!pq.isEmpty() && availableFuel < stations[stationIdx][0] - currentPosition) {
                availableFuel += pq.poll();
                count++;
            }

            if(availableFuel < stations[stationIdx][0] - currentPosition) {
                return -1;
            }

            pq.add(stations[stationIdx][1]);
            availableFuel -= stations[stationIdx][0] - currentPosition;
            currentPosition = stations[stationIdx][0];
            stationIdx++;
        }

        currentPosition += availableFuel;
        while(!pq.isEmpty() && target > currentPosition) {
            currentPosition += pq.poll();
            count++;
        }

        if(target <= currentPosition) {
            return count;
        }

        return -1;
    }
}