class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Long> freq = new HashMap<>();
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int mod = 1000_000_007;
        long count = 0;
        int len = points.length;

        for(int i=0; i<len; i++) {
            freq.put(points[i][1], freq.getOrDefault(points[i][1], (long)0) + 1);
        }

        long prev = 0;
        for(Map.Entry<Integer, Long> entry: freq.entrySet()) {
            if(entry.getValue() > 0) {
                long val = entry.getValue();
                long sides = ((val * (val - 1)) / 2) % mod;
                count += (prev * sides) % mod;
                prev = (prev + sides) % mod;
            }
        }


        return (int)(count%mod);
    }
}