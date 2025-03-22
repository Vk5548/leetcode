/**
given : order , s 
all charac in order : Unique , what bout the character in the s

amnd sorted in some order 

permute the order of s such taht 

turn into a Set
oterate through sarr and append the characetrs to sb in the order they are in the Set
 */

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);


        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()){
            if(freq.containsKey(c)){
                int count = freq.get(c);
                for(int i = 0; i < count; i++)
                    sb.append(c);
                freq.remove(c);
            }
        }

        //remaining characetrs
        for(char c: freq.keySet()){
            int count = freq.get(c);
            for(int i = 0; i < count; i++)
                sb.append(c);
        }
        return sb.toString();

    }
}