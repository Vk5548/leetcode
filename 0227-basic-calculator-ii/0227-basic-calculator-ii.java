/*
String s: expr
integer divi-> 0

CQ: 
1. Can I assume the string is valid or will I ahve to check the valid
2. Are there any special characters like parantheses?
3. I am guessing expres has: +,-,/,*

4 limit to len of expr
5 so I am guessing num> 0
6. What anout the value of expression it yields , would I need to use long?


A: 1
USe a stack to calculate vaues for which it includes + aand -
and calculate the value of *, / on the fly 
T: O(n)
S: O(n)


A2: 2 stacks

*/

class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int len = s.length();
        int num = 0;
        char op = '+';
        for(int i =0; i < len; i++){
            char c = s.charAt(i);
            //numbers can be 2 digit or more
            if (Character.isDigit(c)){
                //accumulate all the digits
                num = num * 10 + c - '0';
            }
            if( (!Character.isDigit(c) && c != ' ') || i == len - 1){
                if(op == '*'){
                    stk.push(stk.pop() * num);
                }else if( op == '/'){
                    stk.push(stk.pop() / num);
                }else if( op == '+'){
                    stk.push(num);
                }else{
                    stk.push(-num);
                }
                num = 0;
                op = c;
            }
        }
        int res = 0;
        while(stk.size() > 0){
            res += stk.pop();
        }
        return res;
    }
}