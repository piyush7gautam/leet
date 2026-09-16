class Solution {
    int[][] dp = new int[1002][1002];
    int fun(String s , String t , int i , int j ){
        if(i>=s.length() || j>=t.length()){
            return 0 ;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1+fun(s,t,i+1,j+1);

        }
        int a = fun(s,t,i+1,j);
        int b = fun(s,t,i,j+1);
        return dp[i][j] = Math.max(a,b);


    }
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
         dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }
         return fun(s,t,0,0);
    }
}