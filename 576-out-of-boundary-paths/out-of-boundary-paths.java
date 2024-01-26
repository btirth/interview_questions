class Solution {

    Integer[][][] dp;
    int MOD = (int)1e9 + 7;
    public int findPaths(int m, int n, int mv, int startRow, int startColumn) {
        dp = new Integer[m+1][n+1][mv+1];
        return dfs(m, n, mv, startRow, startColumn);
    }

    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };

    int dfs(int m, int n, int mv, int i, int j) {
        if(i<0 || j<0 || i==m || j==n) {
            return 1;
        }

        if(mv == 0) {
            return 0;
        }

        if(dp[i][j][mv] != null) {
            return dp[i][j][mv];
        }

        int ans = 0;
        for(int[] dir: directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            ans = (ans + dfs(m, n, mv-1, x, y))%MOD;
        }

        return dp[i][j][mv] = ans;
    }
}