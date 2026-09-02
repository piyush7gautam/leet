class Solution {

    int[] dp = new int[104];

    int fun(int[] nums, int i) {

        if (i >= nums.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int c1 = nums[i] + fun(nums, i + 2);
        int c2 = fun(nums, i + 1);

        int ans = Math.max(c1, c2);

        dp[i] = ans;

        return dp[i];
    }

    public int rob(int[] nums) {

        for (int i = 0; i < 104; i++) {
            dp[i] = -1;
        }

        return fun(nums, 0);
    }
}