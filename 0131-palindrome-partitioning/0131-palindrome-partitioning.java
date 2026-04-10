class Solution {
    boolean[][] dp;
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        int n = s.length();
        dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = true;
                } else {
                    if(j == i + 1) {
                        if(s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = true;
                        } 
                    } else {
                        if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        backtrack(s, 0, new ArrayList<>());
        return res;
    }
    
    void backtrack(String s, int idx, List<String> curr) {
        int n = s.length();
        if(idx == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx; i<n; i++) {
            if(dp[idx][i]) {
                curr.add(s.substring(idx, i+1));
                backtrack(s, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}