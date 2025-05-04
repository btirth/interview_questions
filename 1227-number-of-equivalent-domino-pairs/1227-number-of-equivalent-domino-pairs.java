class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> freq = new HashMap<>();
        int count = 0;

        for(int[] d: dominoes) {
            Arrays.sort(d);
            String key = d[0] + "-" + d[1];
            count += freq.getOrDefault(key, 0);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        return count;
    }
}