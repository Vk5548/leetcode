/* 
Given : s and t :of length m and t 
minimum window substring
such taht every character in is in the wondow, return the window

CQ: 
1 Is the ans unique?
2 when s = "" and t = "", return ""? Y
3 when s = "<some string>", t = "", return ""
4 s = "" and t= "<some string>"", return ""

A: keep tarck of t with a. hashmap, storing freq of teh characetrs
-> form a window, again also using a hashmap to keep of current characetrs
and and if it matches, keep the track if the res in minimum
try to decrease the window
 T: O(m+n)
 S: O(n)

A -> use a a count array of 52? for both a and A
T: O(n)
S: O(n)


*/
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(char c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int required = tMap.size();

        int left = 0, right = 0;
        int len = s.length();

        Map<Character, Integer> currMap = new HashMap<>();
        int current = 0;
        int[] ans = {-1, 0, 0}; // len, left, right

        while ( right < len ){
            char c = s.charAt(right);
            currMap.put(c, currMap.getOrDefault(c, 0) + 1);

            if(tMap.containsKey(c) && tMap.get(c).intValue() == currMap.get(c).intValue()){ // where we have gotten a correct
                current++;
            }


            while (left <= right && required == current){
                c = s.charAt(left);
                
                

                if(ans[0] == -1 || right - left + 1 < ans[0]){
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }//updated the ans

                currMap.put(c, currMap.get(c) - 1);
                if(tMap.containsKey(c) && tMap.get(c).intValue() > currMap.get(c).intValue()){
                    current--;
                }

                left++;

            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);


    }
}