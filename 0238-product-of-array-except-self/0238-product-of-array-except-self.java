class Solution {
    public int[] productExceptSelf(int[] nums) {
        // case no 0; then it works normally
        //case 1: one 0; we need to store the product other numbers to enter this
        //case 2: more than 1 zer0;

        int ctr0 = 0; int idx = -1;
        int productWithoutZero = 1, product = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                ctr0++;
                idx = i;
                if(ctr0 > 1){ //at any point
                    return new int[nums.length];
                }
                productWithoutZero = product;
            }else{
                product *= nums[i];
                productWithoutZero *= nums[i];
            }
        }
        int[] res = new int[nums.length];
        if(ctr0 == 1){  
            res[idx] = productWithoutZero;
            nums = new int[nums.length];
            nums[idx] = productWithoutZero;
        }else{
            for(int i = 0; i < nums.length; i++){
                nums[i] = product/ nums[i];
            }
        }
        return nums;
    }
}