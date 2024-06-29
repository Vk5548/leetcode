class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (curr >= k) {
                curr /= nums[left];
                left++; // A
            }

            ans += right - left + 1;
        }

        return ans;
        
    }
}