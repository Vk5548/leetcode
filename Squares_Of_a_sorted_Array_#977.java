class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int result[] = new int[length];

        // Its a 2 pointer approach: so
        // filling the array form the last index
        // because the original one is in non- decreasing order
        int left = 0, right = length - 1;
        // for(int i = length - 1; i>= 0 && left <= right; i --){
        //     if(nums[left]< nums[right]){
        //         int num = Math.pow(nums[right], 2);
        //         result[i] =  
        //     }
        // }
        int index = length - 1;
        while(left <= right){
            if(Math.abs(nums[left])<= Math.abs(nums[right])){
                result[index--] = nums[right] * nums[right];
                right--;
            }else{
                result[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
}