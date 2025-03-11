class Solution {
    public int calculate(String s) {
        if (s.length() == 0 || s == null){
            return 0;
        }
        int num = 0;
        char op= '+';
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            //check if its digit
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + (s.charAt(i) - '0');
            } // got the digit or the number building up

            // of if the character is op or we at the end of the String
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1){
                if (op == '+'){
                    stk.push(num);
                }else if(op == '-'){
                    stk.push(-num);
                }else if(op == '*'){
                    //get the last num
                    stk.push(stk.pop() * num);
                }else{
                    stk.push(stk.pop() / num);
                }
                // reinitialize num to 0
                num = 0;
                op = s.charAt(i);
            }
        }
        int res = 0;
        while(!stk.isEmpty()){
            res += stk.pop();
        }
        return res;
    }
}