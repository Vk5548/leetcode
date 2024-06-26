class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;
        
        // Iterate through the nums array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // If zeroCount exceeds k, shrink the window from the left
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // Calculate the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}