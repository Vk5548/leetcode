/* 
s: m 
t : n
return the min window substring of s, such that
every charactre of t is included in the window(incl. duplicates)

T1: "ADOBECODEBANC" , "ABC" 
// every character of t should be in teh substring
and order doesn't matter

A1: sliding window
// a list for all characters of t

*/


class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
            
        Map<Character, Integer> tFreq = new HashMap<>();
        for(char c: t.toCharArray()){
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int formed = 0;
        int required = tFreq.size();

        Map<Character, Integer> windowFreq = new HashMap<>();
        int[] ans = {-1, 0, 0}; //length, left, right

        while(right < s.length()){
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if(tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()){
                formed++;
            } // got a avlid substring when formed == required

            while(left <= right && formed == required){
                c = s.charAt(left);

                if(ans[0] == -1 || right - left + 1 < ans[0]){ //checking if we get the a lesser value
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                //Remove form window
                windowFreq.put(c, windowFreq.get(c) - 1);
                // if(windowFreq.get(c) == 0) windowFreq.remove(c);
                if (tFreq.containsKey(c) && windowFreq.get(c).intValue() < tFreq.get(c).intValue()) {
                    formed--;
                }

                left++;

            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        
    }
    
}