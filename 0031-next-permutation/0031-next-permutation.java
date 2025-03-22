/** 
n!
the nextPermu

Q: the max siz eof Nums 
Q: can nums be Empty
Q: are the elelemnets unique in the Array
Q: 

A: to get all the permuattions and then somehow get the next One
: backtarcking, : but if you give est size of n: 100, therefore I wouldnot go with backtarcking

A: There have to be some sort of order 
// so I find the
1 case: all elements are in decreasing order, then we give the sorted ersion of the array
2: all of them are in increasing order, so we can just got n-2 and replace it with n-1
provided they are not same of course

3: 
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // Find the first index i from the right such that nums[i] < nums[i+1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // If such an index is found, find index j to swap with
        if (i >= 0) {
            int j = n - 1;
            // Find the first element greater than nums[i] from the right
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // Reverse the subarray from i+1 to the end to get the next permutation
        reverse(nums, i + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
