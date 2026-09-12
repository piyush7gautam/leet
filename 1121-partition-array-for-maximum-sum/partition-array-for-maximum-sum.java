class Solution {
    int[][] dp = new int[501][501];
     int fun(int[] arr , int prev , int i , int m, int k ){
        if(i >= arr.length){
            return 0;
        }
        int ans = 0;
        if(dp[i][prev] != -1){
          return dp[i][prev];
        }
        
        m = Math.max(m,arr[i]);
        int len = i-prev+1;
        if(len==k){
            int x = (m*len)+fun(arr,i+1,i+1,0,k);
            ans = Math.max(ans,x);
        } else{
             int x = (m*len)+fun(arr,i+1,i+1,0,k);
             int y = fun(arr,prev,i+1,m,k);
             ans = Math.max(ans,x);
             ans = Math.max(ans,y);
        }
         return dp[i][prev] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
          for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                dp[i][j] = -1;
            }
        }

        return fun(arr, 0, 0, 0, k);   
     }
 }
  