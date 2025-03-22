/* 
//and removing all on-alphanueric
a phrase, : therefore spaces, do we need to read the space same?
No


*/
class Solution {
    public boolean isPalindrome(String s) {
        s.trim();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        System.out.println(s);
        int l = 0, r = s.length() - 1;
        while (l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return true;
    }
}