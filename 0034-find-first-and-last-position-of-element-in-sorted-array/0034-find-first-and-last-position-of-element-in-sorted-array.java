/* 
nums[], non-decreaing order-> 1,2,2,4,5,7,7
find teh starting and ending position for given target value;

CQ: 1 -> every elelment can be same
2. does target always exist -> No -> [-1, -1]
3. nums can integers that fit in 32-bit -> Y
4. 


A1:  Single pAss through Arr and finf the target if it exits and see where you find it
T:O(n)
S:O(1)

A2: Binary search and if I find the Mid:
//it can 

I: [1, 2,3,4, 5,5,5,5,5,6,7,7,7,9] -> target :7
14 -> 7

*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target){
            return new int[]{0, 0};
        }
        // if(nums.length == 1 || nums[0] == target){
        //     return new int[]{-1, -1};
        // }
        int left = 0, right = nums.length - 1;

        while( left <= right ){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                int leftIdx = mid, rightIdx = mid;
                while(leftIdx >= 0 && nums[leftIdx] == target) leftIdx--;
                leftIdx++;
                while(rightIdx <= right && nums[rightIdx] == target) rightIdx++;
                rightIdx--;
                return new int[]{leftIdx, rightIdx};
            } else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};

    }
}