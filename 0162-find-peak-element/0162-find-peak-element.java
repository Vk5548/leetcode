class Solution {
    public int findPeakElement(int[] nums) {
        /*
        peak elmenent 
        Input : SIze
        //what happens 3 equal numbers

        Approach:
        1. Time: O(n)
        S: : O(1)
        */
        //inp: [1,2,3,1]
        //o: 2
        int len = nums.length;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            //every lemet
            //i = 0
            if(i == 0){
                if(i+1 < len && nums[i] > nums[i+1] ){
                    res = 0;
                    break;
                }else{
                    continue;
                }
            }
            if(i == len - 1){
                if( i-1 >= 0 && nums[i] > nums[i-1]){
                    res =len - 1;
                    break;
                }else{
                    continue;
                }
            }
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                res = i;
                break;
            }
        }
        return res;
    }
}