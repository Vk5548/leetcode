class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;

        // Pointers for nums1 and nums2
        int i = 0, j = 0;

        // Variables to store current and previous values
        int prev = 0, curr = 0;

        // The median positions
        
        int medianPos2 = totalLength / 2;

        // Iterate until we reach the median position
        for (int count = 0; count <= medianPos2; count++) {
            prev = curr;
            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        // If total length is odd, return the middle element
        if (totalLength % 2 == 1) {
            return curr;
        } else {
            // If total length is even, return the average of the two middle elements
            return (prev + curr) / 2.0;
        }
    }
}
