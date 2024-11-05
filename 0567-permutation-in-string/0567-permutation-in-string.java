import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] count = new int[26];
        int[] copyCount = new int[26];
        for(int i =0; i < s1.length(); i++){
            int k = s1.charAt(i) - 'a';
            count[k]++;
            // the 2nd string, only getting the current window
            k = s2.charAt(i) - 'a';
            copyCount[k]++;
        }
        // track of matches
        int matches = 0;
        for(int i =0;i < 26; i++ ){
            if(count[i]== copyCount[i])
                matches++;
        }
        // for any sliding window problem : we need a left and a write pointer
        int left = 0;
        for(int right =s1.length(); right < s2.length(); right++)
        {
            if(matches == 26) // if all letters are present in both substring
                return true;
            int k = s2.charAt(right) - 'a';// current chraacter int val
            copyCount[k]++; // increasing the frequency
            if(count[k] == copyCount[k])
                matches++;
            if(count[k] + 1 == copyCount[k]) // if value unmatched after the change
                matches--;

            k = s2.charAt(left) - 'a';
            copyCount[k]--; //decreasing the window
            if(count[k] == copyCount[k]) //checking the same thing, if the value unmatched after the chane
                matches++;
             if(count[k] - 1 == copyCount[k])
                matches--;
            left++;
        }     
        return matches == 26 ;
    }
}