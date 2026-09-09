class Solution {
    int[] dp = new int[1004];

    int fun(int[] cost, int i) {
        if (i >= cost.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int x = cost[i] + fun(cost, i + 1);
        int y = cost[i] + fun(cost, i + 2);
        dp[i] = Math.min(x, y);
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int a = fun(cost, 0);
        int b = fun(cost, 1);
        return Math.min(a, b);
    }
}