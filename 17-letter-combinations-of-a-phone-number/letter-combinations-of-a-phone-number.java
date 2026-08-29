class Solution {
    static HashMap<String, String> k = new HashMap<>();
    static{
        k.put("2", "abc");
        k.put("3", "def");
        k.put("4", "ghi");
        k.put("5", "jkl");
        k.put("6", "mno");
        k.put("7", "pqrs");
        k.put("8", "tuv");
        k.put("9", "wxyz");
    }
    static void fun(String digits , int i , String c , List<String> ans){
        if(i == digits.length()){
            ans.add(c);
            return;
        }
        String l = k.get(String.valueOf(digits.charAt(i)));
        for(int j = 0 ; j<l.length() ; j++){
            fun(digits, i+1 ,c+l.charAt(j) ,ans);
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        fun(digits , 0, "" , ans);
        return ans;
        
    }
}