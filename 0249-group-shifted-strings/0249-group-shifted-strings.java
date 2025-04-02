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

        for(String str: strings){
            //check if //traverse them 
            int offset = str.charAt(0) - 'a';

            StringBuilder key = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a'){
                    c += 26;
                }
                key.append(String.valueOf(c));
            }
            String keyStr = String.valueOf(key); 
            if(!map.containsKey(keyStr)){
                List<String> list = new ArrayList<>();
                map.put(keyStr, list);
            }
            map.get(keyStr).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key: map.keySet()){
            List<String> list = map.get(key);
            Collections.sort(list);
            res.add(list);
        }

        return res;
    }
}