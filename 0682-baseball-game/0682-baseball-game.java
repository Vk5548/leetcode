class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < operations.length; i++){
            switch (operations[i]) {
                case "C":
                    stk.pop();
                    break;
                case "D":
                    int x = stk.peek();
                    stk.push(x * 2);
                    break;
                case "+":
                    int second = stk.pop();
                    int first = stk.peek();
                    stk.push(second);
                    stk.push(first+second);
                    break;
            
                default:
                    stk.push(Integer.parseInt(operations[i]));
                    break;
            }
        }
        int res = 0;
        while(!stk.isEmpty()){
            res+= stk.pop();
        }
        return res;
    }
}