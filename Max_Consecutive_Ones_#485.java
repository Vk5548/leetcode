class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int tmp_count = 0;
        for(int num : nums){
            if(num == 1){
                tmp_count++;
            }else{
                if(tmp_count > count){
                    count = tmp_count ;
                    }
                tmp_count = 0;
            }
        }
        if(tmp_count > count){
         count = tmp_count ;
        }
        return count;
    }
}