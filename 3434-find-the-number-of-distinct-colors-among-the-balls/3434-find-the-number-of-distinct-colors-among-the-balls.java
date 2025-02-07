class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> color = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        int n = queries.length;
        int[] ans = new int[n];
        int idx = 0;

        for(int[] q: queries) {
            int prevColor = color.getOrDefault(q[0], -1);

            if(prevColor != -1) {
                freq.put(prevColor, freq.get(prevColor) - 1);
                if(freq.get(prevColor) == 0) {
                    freq.remove(prevColor);
                }
            }

            color.put(q[0], q[1]);
            freq.put(q[1], freq.getOrDefault(q[1], 0) + 1);
            ans[idx] = freq.size();
            idx++;
        }

        return ans;
    }
}