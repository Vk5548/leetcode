class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, min = Integer.MAX_VALUE, sum = 0;
        
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                sum -= nums[left];
                min = Math.min(min, right-left+1);
                left++;
            }
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
        
    }
}