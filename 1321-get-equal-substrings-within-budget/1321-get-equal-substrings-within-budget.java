class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, length = 0, maxLen = Integer.MIN_VALUE, total = 0;
        for(int right = 0; right < s.length(); right++){
            total += Math.abs((int)s.charAt(right) - (int)t.charAt(right));
            length++;
            while(total > maxCost){
                total -= Math.abs((int)s.charAt(left) - (int)t.charAt(left));
                length--;
                left++;
            }
            maxLen = Math.max(maxLen, length);
        }
        return maxLen;
    }
}