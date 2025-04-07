/* 

int[] nums , k -> boolean
A good sub: len >= 2 and sum of elem in the subarr is a multiple of k

I : [1,2,3,4,5,6], k = 3

Cq: can nums be less than size 2: [9] and k = 3-> false
if its null -> return falsr

A: 2 ptr approach , add elemnts in my window and as soon as I find a good sub array return true;
else return false

A: can't 2 ptr becuase, I will need some sort of Prefix sum as well
but store modulo in the map across idx

*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //base case
        if(nums.length == 0 || nums.length == 1) return false;
        Map<Integer, Integer> remMap = new HashMap<>();
        remMap.put(0, -1);
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            curr += nums[i];
            if(remMap.containsKey(curr % k)){
                int left = remMap.get(curr % k);
                if(i - left >= 2){
                    return true;
                }
            }else{
                remMap.put(curr % k, i);
            }
            
        }
        return false;

    }
}