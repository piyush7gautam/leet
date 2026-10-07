class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
          Deque<Integer> d = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int curr = 0;

        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && nums[d.peekLast()] <= nums[i]) {
                d.pollLast();
            }
            d.offerLast(i);
            while (d.peekFirst() <= i - k) {
                d.pollFirst();
            }
            if (i >= k - 1) {
                ans[curr++] = nums[d.peekFirst()];
            }
        }
        return ans;
    }
}