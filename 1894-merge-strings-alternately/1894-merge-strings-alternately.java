class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(idx < word1.length() && idx < word2.length()){
            sb.append("" + word1.charAt(idx)).append("" + word2.charAt(idx));
            idx++;
        }
        if(idx < word1.length()){
            sb.append(word1.substring(idx++));
        }
        if(idx < word2.length()){
            sb.append(word2.substring(idx++));
        }
        return sb.toString();
        
    }
}