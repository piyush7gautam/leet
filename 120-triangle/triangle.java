class Solution {
    int[][] dp = new int[201][201];

    int fun(int i, int j, List<List<Integer>> grid) {
        int n = grid.size();

        if (i >= n || j >= grid.get(i).size()) {
            return 1000000000;
        }

        if (i == n - 1) {
            return grid.get(i).get(j);
        }

        if (dp[i][j] != -100000000) {
            return dp[i][j];
        }

        int x = grid.get(i).get(j) + fun(i + 1, j, grid);
        int y = grid.get(i).get(j) + fun(i + 1, j + 1, grid);

        return dp[i][j] = Math.min(x, y);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                dp[i][j] = -100000000;
            }
        }

        return fun(0, 0, triangle);
    }
}