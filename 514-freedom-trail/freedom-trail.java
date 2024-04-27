class Solution {
    HashMap<Character, List<Integer>> map;
    String ring;
    String key;
    int[][] dp;
    public int findRotateSteps(String ring, String key) {
        int keyLen = key.length();
        int ringLen = ring.length();
        dp = new int[ringLen][keyLen];
        map = new HashMap<>();
        this.ring = ring;
        this.key = key;

        for(int i=0; i<ring.length(); i++) {
            List<Integer> list = map.getOrDefault(ring.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(ring.charAt(i), list);
        }

        return helper(0, 0);
    }

    int helper(int ringIdx, int keyIdx) {
        if(keyIdx == key.length()) {
            return 0;
        }

        if(dp[ringIdx][keyIdx] != 0) {
            return dp[ringIdx][keyIdx];
        }

        int res = Integer.MAX_VALUE;
        for(Integer nextIdx: map.get(key.charAt(keyIdx))) {
            int minDist = Math.min(
                Math.abs(ringIdx - nextIdx),
                ring.length() - Math.abs(ringIdx - nextIdx)
            );
            res = Math.min(res, minDist + helper(nextIdx, keyIdx+1) + 1);
        }

        return dp[ringIdx][keyIdx] = res;
    }
}