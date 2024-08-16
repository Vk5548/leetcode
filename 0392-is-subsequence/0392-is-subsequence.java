class Solution {
    public boolean isSubsequence(String s, String t) {
        int first = 0;
        if(s == ""){
            return true;
        }
        for(int second = 0; second < t.length(); second++){
            if(first >= s.length()){
                break;
            }
            if (s.charAt(first) == t.charAt(second)){
                first++;
            }
        }
        if(first == s.length()){
            return true;
        }
        return false;
    }
}