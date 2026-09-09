class Solution {
    int[] dp = new int[1000];

    int fun(int[] days, int[] cost, int i) {
        if (i >= days.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int c1 = cost[0] + fun(days, cost, i + 1);
        int id1 = days.length;
        int id2 = days.length;
        for (int j = i + 1; j < days.length; j++) {
            if (days[j] >= days[i] + 7) {
                id1 = j;
                break;
            }
        }
        for (int j = i + 1; j < days.length; j++) {
            if (days[j] >= days[i] + 30) {
                id2 = j;
                break;
            }
        }
        int c2 = cost[1] + fun(days, cost, id1);
        int c3 = cost[2] + fun(days, cost, id2);
        dp[i] = Math.min(c1, Math.min(c2, c3));
        return dp[i];
    }

    public int mincostTickets(int[] days, int[] costs) {
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return fun(days, costs, 0);
    }
}