class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // Return empty if input array is empty
        }
        StringBuilder sb = new StringBuilder();
        int j = 0;
        //how many strings are there?
        int numofStrings = strs.length;
        while(true){
            if (j >= strs[0].length()) { // if the 1st string is smaller, return here itself
                return sb.toString();
            }
            //get the ith character from string
            char ch = strs[0].charAt(j); // jth character of first string
            for(int i = 1; i < strs.length; i++){
                //if the jth character matches for every string
                if(j >= strs[i].length() || ch != strs[i].charAt(j)){
                    return sb.toString();
                }
            }//got the jth character for every string?
            sb.append(ch);
            j++;
        }
        // return sb.toString();
    }
}