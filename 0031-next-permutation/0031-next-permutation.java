class Solution {
    public void nextPermutation(int[] nums) {
        //to find the first index that needs to be changed for the next nextPermutation

        int n = nums.length;
        int i = n - 2;
        while ( i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }// got the "i"; which will be changed with greater number
        //finding the index of the greater number
        int j = n - 1;
        if(i >= 0){ //if such an index is found

            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j){
        while ( i <= j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}