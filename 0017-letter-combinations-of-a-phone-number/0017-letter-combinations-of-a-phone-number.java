class Solution {
    Map<Character, String> numberMap = new HashMap<>(); 
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return result;
        }
       // store into map:
       //loop over abc
       numberMap.put('2', "abc");
       numberMap.put('3', "def");
       numberMap.put('4', "ghi");
       numberMap.put('5', "jkl");
       numberMap.put('6', "mno");
       numberMap.put('7', "pqrs");
       numberMap.put('8', "tuv");
       numberMap.put('9', "wxyz");
       backtrack(new StringBuilder(), digits, 0);
       return result;
    }
    private void backtrack(StringBuilder curr, String digits, int index){
        if(curr.length() == digits.length()){
            result.add(curr.toString());
            return;
        }

        char ch = digits.charAt(index);
        String str = numberMap.get(ch);

        for(int i = 0; i < str.length(); i++){
            curr.append(str.charAt(i));
            backtrack(curr, digits, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}