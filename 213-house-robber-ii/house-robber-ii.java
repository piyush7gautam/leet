class Solution {
    int[][] dp = new int[104][2];
    int fun(int[] nums, int i, int flag) {
        if (i >= nums.length)
            return 0;
        if (i == nums.length - 1 && flag == 1)
            return 0;
        if (dp[i][flag] != -1)
            return dp[i][flag];
        int newFlag = flag;
        if (i == 0)
            newFlag = 1;
        int c1 = nums[i] + fun(nums, i + 2, newFlag);
        int c2 = fun(nums, i + 1, flag);
        int ans = Math.max(c1, c2);
        dp[i][flag] = ans;
        return dp[i][flag];
    }
    public int rob(int[] nums) {
        for (int i = 0; i < 104; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return fun(nums, 0, 0);
    }
}