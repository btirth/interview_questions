class Solution {
    boolean[][] dp;
    int n;
    String s;
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        this.s = s;
        n = s.length();
        dp = new boolean[n][n];
        ans = new ArrayList<>();

        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = true;
                } else if(i+1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        helper(0, new ArrayList<>());
        return ans;
    }

    void helper(int start, List<String> list) {
        if(start == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<n; i++) {
            if(dp[start][i]) {
                list.add(s.substring(start, i+1));
                helper(i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}