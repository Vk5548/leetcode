/*

kth missing +ve integer

 */

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int curr = 1; // current number to check
        int idx = 0;  // pointer for arr[]

        while (missingCount < k) {
            if (idx < arr.length && arr[idx] == curr) {
                idx++; // current number exists in arr
            } else {
                missingCount++;
                if (missingCount == k) {
                    return curr;
                }
            }
            curr++;
        }

        return -1; // should never be hit
    }
}
