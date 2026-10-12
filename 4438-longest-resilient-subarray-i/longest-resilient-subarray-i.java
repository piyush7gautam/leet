class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int m = 1;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int r = nums[i] % k;
            for (int j = i; j < n; j++) {
                if (nums[j] % k != r) {
                    break;
                }
                sum = (sum + nums[j]) % k;
                if (sum == r) {
                    m = Math.max(m, j - i + 1);
                }
            }
        }
        return m;
    }
}