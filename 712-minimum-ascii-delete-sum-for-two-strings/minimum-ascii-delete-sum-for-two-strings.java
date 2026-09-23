class Solution {
    int[][] dp = new int[1001][1001];

    int fun(int i, int j, String s, String t) {

        if(i >= s.length()) {
            int sum = 0;

            for(int z = j; z < t.length(); z++) {
                sum += t.charAt(z);
            }

            return sum;
        }

        if(j >= t.length()) {
            int sum = 0;

            for(int f = i; f < s.length(); f++) {
                sum += s.charAt(f);
            }

            return sum;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int m = 1000000000;

        if(s.charAt(i) == t.charAt(j)) {
            m = Math.min(m, fun(i + 1, j + 1, s, t));
        }

        int b = s.charAt(i) + fun(i + 1, j, s, t);
        int c = t.charAt(j) + fun(i, j + 1, s, t);

        m = Math.min(m, b);
        m = Math.min(m, c);

        return dp[i][j] = m;
    }

    public int minimumDeleteSum(String s1, String s2) {

        dp = new int[s1.length()][s2.length()];

        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return fun(0, 0, s1, s2);
    }
}