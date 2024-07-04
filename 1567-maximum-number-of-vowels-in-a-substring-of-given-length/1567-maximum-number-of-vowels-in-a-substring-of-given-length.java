class Solution {
    public int maxVowels(String s, int k) {
        Set<Character>  hs = new HashSet<>();
        hs.add('a'); hs.add('e'); hs.add('i'); hs.add('o'); hs.add('u');
        int maximum = 0, curr = 0;
        for(int right = 0; right< k;right++){
            if (hs.contains(s.charAt(right))){
                curr++;
            }
        }
        maximum = curr;
        for(int right = k; right < s.length(); right++){
            if (hs.contains(s.charAt(right))){
                curr++;
            }
            if (hs.contains(s.charAt(right - k))){
                curr--;
            }
            maximum = Math.max(maximum, curr);
        }
        return maximum;
        
    }
}