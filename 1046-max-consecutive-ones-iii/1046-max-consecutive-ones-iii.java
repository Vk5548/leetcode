/*
nums[] ; {0, 1}, k
return the max number of 1's in the array, if you can flip at most k 0'Solution

meaning return the longest string or num such that you can have at most k 0's


Cq: 
1. can k be 0? -> so all 1'
2. nums is null, what -> 0
3. can k ne -ve?, No right , meaning 0


A: sliding window such that I can have at most k 0's and get the length of the longest subsequence
and slide teh window when you have k + 1, zeroes in case and store the max length
T: O(n);
S: O(1);

 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, curr = 0;
        int left = 0, right = 0;
        int tempK = 0;
        while(right < nums.length){
            curr++;
            if(nums[right] == 0) tempK++;
            if(tempK <= k){
                    maxLen = Math.max(maxLen, right - left + 1);
            };
            while(tempK > k){
                //increase teh left
                if(nums[left] == 0){
                    tempK--;    
                }
                left++;
                
            }
            right++;
        }
        return maxLen;

    }
}