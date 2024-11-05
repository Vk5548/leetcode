class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // //sliding Window
        // int left = 0;
        // int right = left + 1;
        // int n = temperatures.length;
        // int[] result = new int[n];
        // for (left =0; left < n; left++){
        //     right = left + 1;
        //     while( right < n &&temperatures[left] >= temperatures[right]){
        //             right++;
        //         }
        //         if(right < n && temperatures[left] < temperatures[right]){
        //             result[left] = right - left;
        //         }
        //         else{
        //             result[left] = 0;
        //         }
                
        //     }
        // return result;

        // USING STACK
        Stack<Integer> stk = new Stack<>(); //  index
        int n = temperatures.length;
        int[] result = new int[n];
        stk.push(0);
        for(int i = 1; i < n; i++){
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]){
                int index = stk.pop();
                result[index] = i - index;

            }
            stk.push(i);
        }
        return result;
    }
}