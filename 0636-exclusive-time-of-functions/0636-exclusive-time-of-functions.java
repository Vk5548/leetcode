/* 
single-threaded ;; n functions; at a time , 1 would execute
0 to n-1
0:start:3
"1:end:2"

use a  Stack and store all three and when you pop: add the time 


*/

class Solution {
    
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[n];
        int prevTime = 0;
        for(String log: logs){
            String[] parts = log.trim().split(":");
            int funcId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);
            if(parts[1].equals("start")){ // we only push start
                if(!stk.isEmpty()){
                    res[stk.peek()] += time - prevTime;
                }
                stk.push(funcId);
                prevTime = time;
                
            }else{ // we pop end
                res[stk.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }

        return res;
    }
}

/*

How will I know and keep track of the execution time, so fr */