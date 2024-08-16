class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int next_zero_flipped = 0, seq_without_zero = 0;
        int res = 0;
        for(int num: nums){
            if(num == 0){
                res = Math.max(res, next_zero_flipped);
                next_zero_flipped = seq_without_zero + 1;
                seq_without_zero = 0;
            }else{
                seq_without_zero +=1;
                next_zero_flipped += 1;
            }
        }
        res = Math.max(next_zero_flipped, res);
        res = Math.max(res, seq_without_zero);
        return res;
    }
}