

/*
, can x be -ve
can n ne -ve
can both of them be 0 at the same time and if yes, how handle?

A: using recursion
x^n = (x*x)^n/2
n is an int a 32-bit int, meaning I will needlong to handle the ase if is n is the minimum value of 32-buit= -214----8
Max_int = 214----7

 

*/
class Solution {
    public double myPow(double x, int n) {
        if(x == 0)
            return 0;
        
        return solve(x, (long)n);
    }
    private double solve(double x, long n){
        if ( n == 0 ){
            return 1;
        }
        if( n < 0 ){
            return solve (1/x, -n);
        }
        if( n % 2 == 0 ){
            return solve(x*x, n/2);
        } 
        return x * solve(x*x, (n-1)/ 2);
    }


}