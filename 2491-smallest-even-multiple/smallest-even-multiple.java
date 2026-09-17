class Solution {
    int fun(int n ){
        if(n % 2 == 0)
        return n ;

       
            for(int i = 1 ; i<= 150 ; i++){ 
               for(int j = 1 ; j<= 150 ; j++){
                if (i * 2 == n * j) {
                    return i * 2;
                }

                }
            }
        return n ;
       
    }
    public int smallestEvenMultiple(int n) {
        return fun(n);
    }
}