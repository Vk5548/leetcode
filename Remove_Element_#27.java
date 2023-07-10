class Solution {
    public int removeElement(int[] nums, int val) {
        // int left = 0, right = nums.length - 1;
        // while(left < right){
        //     if(nums[left] == val){
        //         if(nums[right] == val){
        //             right--;
        //         }else{
        //             nums[left++] = nums[right--];
        //         }
        //     }else{
        //         left++;
        //     }
        // }
        // return left;

        //The above method was my second first intuition
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}