class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        //so we are sorting, Why??
        //because nums[i] + nums[j] == nums[j] + nums[i]
        //therefore, it doesn't matter
        Arrays.sort(nums);

        int lowerPairs = 0, upperPairs = 0;
        // int right = nums.length;
        long res = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            lowerPairs = lowerBound(nums, i+1, n, lower - nums[i]);
            upperPairs = upperBound(nums, i+1, n, upper - nums[i]);
            res += upperPairs - lowerPairs;
        }
        return res;
    }

    private int lowerBound(int[] nums, int left, int right, int target){
        // int res = 0;
        while(left < right){
            int mid = left+ (right-left)/2;

            if(nums[mid] >= target){
                // res = mid;
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private int upperBound(int[] nums, int left, int right, int target){
       
        while(left < right){
            int mid = left+ (right-left)/2;

            if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}