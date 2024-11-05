class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        // Populate the frequency map with characters from magazine
        for (char ch : magazine.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        // Check if ransomNote can be constructed using the magazine
        for (char ch : ransomNote.toCharArray()) {
            if (freq.containsKey(ch)) {
                int count = freq.get(ch);
                if (count - 1 == 0) {
                    freq.remove(ch);
                } else {
                    freq.put(ch, count - 1);
                }
            } else {
                return false; // Character in ransomNote not found in magazine or insufficient count
            }
        }
        
        return true;
    }
}
