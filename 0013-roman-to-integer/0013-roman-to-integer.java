class Solution {
    Map<Character, Integer> map = new HashMap<>();

    public int romanToInt(String s) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for(int i = s.length() -1; i>=0; i--){
            
            char ch = s.charAt(i);
            if(i != s.length() - 1){
                int current = map.get(ch);
                int prev = map.get(s.charAt(i+1));
                if(prev > current)
                    result -= map.get(ch);
                else{
                    result +=map.get(ch);
                }
            }
            else
                result += map.get(ch);
        }
        //largest to smallest
        //if a smaller number comes befor a larger number we substract it
        return result;
    }
}