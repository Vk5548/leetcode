
/**
nums[], int Target
return the indixes who sums upto Target

I : [5,2,3,4,1] : target = 8
CQ: can nums can negative numbers? Y
-> target may be 0: -5, 5
Q: will there be a unique sol : Yes
can what if 2 * nums[i] = target, do we have to ahve different indices?

A: Map<nums[i], i>
I : 1,2,3,4,5  T = 4, 
1: 0, target - curr, 4- 3 in map
O: int[0,2]

T: O(n)
S: O(n) 

 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(idxMap.containsKey(target - nums[i])){
                return new int[]{i, idxMap.get(target - nums[i])};
            }
            idxMap.put(nums[i], i);
        }
        return new int[2];
    }
}