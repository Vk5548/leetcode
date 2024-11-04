class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if(target == nums[left]){
            return left;
        }
        if(target == nums[right]){
            return right;
        }

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[left] < nums[right]){//whole array is sorted
                if(nums[mid] == target){
                    return mid;
                }
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid+1;
                }
            }else{ //if not sorted
                //find the sorted half
                if(nums[left] <= nums[mid]){//left half is sorted
                    //check if target is in this half?
                    if(target == nums[mid]){
                        return mid;
                    }else if(nums[mid] >= target && target >= nums[left]){
                        //target in sorted half
                        right = mid - 1;
                    }else{
                        //target is in the other half
                        left = mid + 1;
                    }

                }else{ // meaning right half is sorted
                    if(target == nums[mid]){
                        return mid;
                    }
                    else if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

            }
        }
        return -1;
    }
}