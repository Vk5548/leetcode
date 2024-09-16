class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack();

        for(char ch: s.toCharArray()){
            switch (ch){
                case '(':
                case '[':
                case '{':
                    stk.push(ch);
                    break;

                case '}':
                    if(stk.isEmpty() || stk.pop() != '{'){
                        return false;
                    }
                    break;
                case ')':
                    if(stk.isEmpty() || stk.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(stk.isEmpty() || stk.pop() != '['){
                        return false;
                    }
                    break;

            }
        }
        return stk.isEmpty();
    }
}