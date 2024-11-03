class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int x = nums[0];
        int upperLimit = x + k;
        int res = 1;
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] > upperLimit){
                res++;
                x = nums[i];
                upperLimit = x +k;
            }
        }
        return res;
    }
}