class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];

        for(int i=0; i<n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));

        double previous = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            double timeItReach = (double)(target - pairs[i][0]) / pairs[i][1];
            if(timeItReach > previous) {
                previous = timeItReach;
                count++;
            }
        }

        return count;
    }
}