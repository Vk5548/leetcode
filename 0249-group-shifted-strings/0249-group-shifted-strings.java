/*
Right Shift : every character by next charcater with z wrapping wround
Left Shift; just the other way round

A1: Use a HashMap and put strings with List of string in it,
tarverse through the array of strings and shift them in 1 direction or the other
depending on how far they are from the start, if not : left-shift;
else right shift

CQ: Can strings be empty?
2. are there only lowercase strings? or does the case matter?
3. 
 */

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        // O(n) : for grouping strings

        for(String str: strings){ // O(n)
            //check if //traverse them 
            int offset = str.charAt(0) - 'a'; // O(1)
           
            StringBuilder key = new StringBuilder(); // O(1)
            for(int i = 0; i < str.length(); i++){ // O(l) ; len of string
                char c = (char) (str.charAt(i) - offset); // O(1)
                
                if (c < 'a'){// wrap around.   // O(1)
                    c += 26; // made the same character.  // O(1)
                }
                key.append(String.valueOf(c));  // O(1)
            }
            String keyStr = String.valueOf(key); // O(l)
            
            map.putIfAbsent(keyStr, new ArrayList<>()); // O(1)
            map.get(keyStr).add(str); // O(1)
        }
        List<List<String>> res = new ArrayList<>();  // O(1)
        for(String key: map.keySet()){ // O(G); total number of unique keys
            List<String> list = map.get(key); // O(1)
            Collections.sort(list); // O(k log k) per group, total O(n log L)
            res.add(list);
        }

        return res;
    }
}