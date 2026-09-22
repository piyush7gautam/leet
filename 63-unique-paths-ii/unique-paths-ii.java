class Solution {
    int[][] dp = new int[105][105];
    int fun(int[][] og, int i, int j, int n, int m) {
        if(i >= n || j >= m || i < 0 || j < 0 || og[i][j] == 1)
            return 0;

        if(i == n-1 && j == m-1)
            return 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        int x = fun(og, i+1, j, n, m);
        int y = fun(og, i, j+1, n, m);

        dp[i][j] = x + y;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] og) {
        int n = og.length;
        int m = og[0].length;
        if(og[0][0] == 1 || og[n-1][m-1] == 1)
            return 0;

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(og, 0, 0, n, m);
    }
}