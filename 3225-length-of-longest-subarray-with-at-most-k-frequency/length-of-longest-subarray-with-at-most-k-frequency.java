    class Solution {
    int fun(int[] nums, int k, int l, int r) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int ans = 0;
        while (r < nums.length) {
            hash.put(nums[r], hash.getOrDefault(nums[r], 0) + 1);
            while (hash.get(nums[r]) > k) {
                hash.put(nums[l], hash.get(nums[l]) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
    public int maxSubarrayLength(int[] nums, int k) {
        return fun(nums, k, 0, 0);
    }
}
