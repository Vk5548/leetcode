class Solution {
    public int findClosestNumber(int[] nums) {
        //closest number to 0:
        //meaning abs val of any number which is closest to 0, and , and any 2 numbers
        // that are close to 0 at any given point, have to be negative of each other

        int num = nums[0]; // always positive value I will store
        
        for(int i = 1; i < nums.length; i++){
            if(Math.abs(nums[i]) < Math.abs(num)){
                num = nums[i];
                
            }else if (Math.abs(nums[i]) == Math.abs(num) && nums[i] > num) {
                num = nums[i];
            }
        }
        
        return num;
    }
}