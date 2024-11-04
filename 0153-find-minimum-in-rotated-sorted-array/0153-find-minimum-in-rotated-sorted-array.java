class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = nums[0];
        
        while (left < right) {
            if (nums[left] < nums[right]) {
                res = Math.min(res, nums[left]);
                break;
            }
            
            int mid = left + (right - left) / 2;
            res = Math.min(res, nums[mid]);
            
            if (nums[mid] >= nums[left]) {
                // Left to mid is sorted, move left pointer to mid + 1
                left = mid + 1;
            } else {
                // Mid to right is sorted, move right pointer to mid - 1
                right = mid - 1;
            }
        }
        
        return Math.min(res, nums[left]);
    }
}
