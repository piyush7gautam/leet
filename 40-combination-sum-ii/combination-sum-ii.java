class Solution {
    static void fun(int[] nums , int target , int s , List<Integer>c , List<List<Integer>>ans){
        if(target == 0){
            ans.add(new ArrayList<>(c));
            return;
        }
        
        for(int i = s ; i<nums.length ; i++){
            if(i>s && nums[i]==nums[i-1]) continue;
            if(nums[i] > target) continue;
            c.add(nums[i]);
            fun(nums ,target-nums[i],i+1,c,ans);
            c.remove(c.size()-1);
        }
      
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        fun(nums, target, 0, new ArrayList<>(), ans);
        return ans;
    }
}