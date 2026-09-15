class Solution {
    int[][] dp = new int[1002][1002];
     int fun(int i, int j, String s, String t) {
        if (i >= s.length() || j >= t.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + fun(i + 1, j + 1, s, t);
        }

        int a = fun(i + 1, j, s, t);
        int b = fun(i, j + 1, s, t);

        return dp[i][j] = Math.max(a, b);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return fun(0, 0, text1, text2);
    }
}