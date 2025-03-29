/* 
order and s 
// achars in order are custom and uniique
// get the chracters from s 
and store it in an count array, concists of lower case characters


*/

class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray())
            count[c - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        for(char c: order.toCharArray()){
            sb.append(String.valueOf(c).repeat(count[c - 'a']));
            // for(int i = 0; i < count[c - 'a']; i++)
            //     sb.append(c);
            count[c - 'a'] = 0;
        }
        for(int i = 0; i < 26; i++){
            sb.append(String.valueOf((char)('a' + i)).repeat(count[i]));
        }
        return sb.toString();
    }
}