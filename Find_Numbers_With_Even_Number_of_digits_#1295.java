class Solution {
    public int findNumbers(int[] nums) {
        // I had ofcourse the idead of
        //divinding it by 10 and getting all the digits:
        //but a. smarter way would be: 
        int count = 0;
        for(int x: nums){
            if((x >= 10 && x < 100) || (x >= 1000 && x < 10000) ||
            (x == 100000 )){
                count++;
            }
        }
        return count;
    }
}