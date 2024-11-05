class Solution {
    String[] str;
    int len;
    public int evalRPN(String[] tokens) {
        this.str=tokens; // copying the array;
        this.len=tokens.length-1;
        return cal();
    }
    int cal(){ // recursion
        String ch=str[len--];
        switch(ch){
            case "+":return cal()+cal();
            case "-":return -cal()+cal();
            case "*":return cal()*cal();
            case "/":int x=cal();
                    int y=cal();
                    return y/x;
            default:return Integer.valueOf(ch);
        }
    }

}
