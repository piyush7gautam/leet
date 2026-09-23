class Solution {
    int[][] dp;
    int fun(int i, int j, int[] nums1, int[] nums2) {

        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i] == nums2[j]) {
            return dp[i][j] = 1 + fun(i + 1, j + 1, nums1, nums2);
        }

        int a = fun(i + 1, j, nums1, nums2);
        int b = fun(i, j + 1, nums1, nums2);

        return dp[i][j] = Math.max(a, b);
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(0, 0, nums1, nums2);
    }
}