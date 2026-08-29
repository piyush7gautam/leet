class Solution {
    static void fun(int[] nums  , int target , List<Integer>c,List<List<Integer>>ans , int s){
        if(target == 0){
            ans.add(new ArrayList<>(c));
            return;
        }
        for(int i = s ; i < nums.length ; i++){
            if(target < nums[i]) continue;
            c.add(nums[i]);
             fun(nums, target - nums[i], c, ans,i);
            c.remove(c.size() -1 );
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    fun(nums,target, new ArrayList<>(), ans,0);
    return ans;
    }
}