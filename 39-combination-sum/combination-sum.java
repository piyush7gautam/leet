class Solution {
    static void find(int[] candidates, int start, int target,List<Integer> current,List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target) {
                continue;
            }

            current.add(candidates[i]);

            find(candidates, i, target - candidates[i], current, result);

            current.remove(current.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();

        find(candidates, 0, target,
             new ArrayList<>(), result);

        return result;
    }
}