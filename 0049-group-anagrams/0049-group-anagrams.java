class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> check = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if(!check.containsKey(sortedStr)){
                check.put(sortedStr, new ArrayList<>());
            }
            List<String> lst = check.get(sortedStr);
            lst.add(str);
            check.put(sortedStr, lst);
        }
        check.values().forEach(val -> result.add(val));
        return result;
    }
}