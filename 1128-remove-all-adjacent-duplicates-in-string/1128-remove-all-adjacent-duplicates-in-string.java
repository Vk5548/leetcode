class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack();
        for(char ch: s.toCharArray()){
            if(!stk.isEmpty() && stk.peek() == ch){
                stk.pop();
                continue;
            }else{
                stk.push(ch);
            }
        }
        if(!stk.isEmpty()){
            StringBuilder sb = new StringBuilder();
            while(!stk.isEmpty()){
                sb.append(stk.pop());
            }
            return sb.reverse().toString(); 
        } 
        return "";
    }
}