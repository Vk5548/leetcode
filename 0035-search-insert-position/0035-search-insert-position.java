class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left <= right){
             mid = left + (right - left)/ 2;

           if(target <= nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
        
    }
}