class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;


        while(left <= right){
           if(s.charAt(left) != s.charAt(right)){ //mismatch
                return checkPlaindrome( left + 1, right, s) || checkPlaindrome(left, right- 1, s);
           }
           left++;
           right--;
        }
        return true;
    }
    private boolean checkPlaindrome(int left, int right, String s){
        while(left <= right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}