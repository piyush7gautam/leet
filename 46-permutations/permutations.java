class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        fun(nums, temp, ans);

        return ans;
    }

    static void fun(int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (temp.contains(nums[i])) {
                continue;
            }

            temp.add(nums[i]);

            fun(nums, temp, ans);

            temp.remove(temp.size() - 1);
        }
    }
}