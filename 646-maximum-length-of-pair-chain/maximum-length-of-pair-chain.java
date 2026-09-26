class Solution {
    int[][] dp = new int[1001][1001];
    int fun(int[][] pairs, int idx, int pre) {
        if (idx >= pairs.length) {
            return 0;
        }

        if (dp[idx][pre + 1] != -1) {
            return dp[idx][pre + 1];
        }
        int m = 0;
        if (pre == -1 || pairs[idx][0] > pairs[pre][1]) {
            int a = 1 + fun(pairs, idx + 1, idx);
            m = Math.max(m, a);
        }
        int b = fun(pairs, idx + 1, pre);
        m = Math.max(m, b);

        dp[idx][pre + 1] = m;
        return m;
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(pairs, 0, -1);
    }
}