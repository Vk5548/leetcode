class Solution {
    public int removeDuplicates(int[] nums) {
        //non-decreasing order
        int left = 1, right = 0;
        for(right  = 1; right < nums.length; right++){
           if(nums[right] != nums[right - 1]){
            nums[left++] = nums[right];
           }
        }
        return left ;
    }
}