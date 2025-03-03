
import java.util.*;
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){ //push it onto stk
                stk.push(i);
            }else if(c == ')'){ //we pop from stk.
                if(stk.isEmpty()){ // we have extra closing parantheses
                    // we can remove these parantheses
                    sb.setCharAt(i, '*');
                }else{
                    stk.pop();
                }
            }
        }
        while (!stk.isEmpty()) {
            int i = stk.pop();
            sb.setCharAt(i, '*');
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != '*'){
                res.append(sb.charAt(i));
            }
        }
        return res.toString();

        
    }
}