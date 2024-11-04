class Solution {
    public boolean isPerfectSquare(int num) {
        // given a int 'n'; return true if n is perfect isPerfectSquare
        // if x * x = n;
        // either I start from n iterate through 1 to n and see if I match anything else returns false
        int left = 1, right = num;
        while(left <= right){
            long mid = left + (right - left) / 2;

            if(mid == num / mid && num % mid == 0){
                return true;
            }else if(mid*mid < num){
                left = (int) mid + 1;
            }
            else{
                right = (int) mid - 1;
            }
            
        }
        return false;
    }
}