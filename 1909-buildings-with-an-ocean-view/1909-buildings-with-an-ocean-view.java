class Solution {
    class Pair{
        int value;
        int index;

        Pair(int v, int i){
            value = v;
            index = i; 
        }
    }
    public int[] findBuildings(int[] heights) {
        //using Stack : Monotonic decreasing
        Stack<Pair> stk = new Stack<>();
        //iterating
        stk.add(new Pair(heights[0], 0));
        for(int i = 1; i < heights.length; i++){
            
                while(!stk.isEmpty() && stk.peek().value <= heights[i]){
                    stk.pop();
                }
                stk.add(new Pair(heights[i], i));
           
        }
        int[] res;
        if(!stk.isEmpty()){
            //gather teh results into an array
            int len = stk.size();
            res = new int[len];
            for(int i = len-1; i>= 0 ; i--){
                res[i] = stk.pop().index;
            }
        }else{
            res = new int[0];
        }
        return res;
    }
}