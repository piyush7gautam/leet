class Solution {
    int[][] dp = new int[2505][2505];
    int fun(int[] nums, int f, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i][f + 1] != -1) {
            return dp[i][f + 1];
        }
        int ans;
        if (f == -1 || nums[i] > nums[f]) {
            int a = 1 + fun(nums, i, i + 1);  
            int b = fun(nums, f, i + 1);      
            ans = Math.max(a, b);
        } else {
            ans = fun(nums, f, i + 1);        
        }
        return dp[i][f + 1] = ans;
    }
    public int lengthOfLIS(int[] nums) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(nums, -1, 0);
    }
}