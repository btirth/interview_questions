class Solution {
    List<String> dictionaryList;
    int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        dictionaryList = Arrays.asList(dictionary);
        int len = s.length();
        dp = new int[len];
        Arrays.fill(dp, -1);

        return helper(s, 0);
    }

    int helper(String s, int idx) {
        if(idx == s.length()) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int min = Integer.MAX_VALUE;
        for(int i=idx; i<s.length(); i++) {
            if(dictionaryList.contains(s.substring(idx, i+1))) {
                min = Math.min(min, helper(s, i+1));
            }
        }

        min = Math.min(min, 1 + helper(s, idx+1));
        return dp[idx] = min;
    }
}