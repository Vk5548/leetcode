class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        
        // Calculate the sum of the first `k` elements
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window through the array
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        // Return the maximum average
        return (double) maxSum / k;
    }
}
