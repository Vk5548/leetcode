
/* 
Q : nums[]:sorted?n, k
R: total number of subarrays , whose sum = k
is the array sorted?

CQ: nums[i]?
range of k?

I : [2,3,4,5,7], k = 7
O: || = 2

I: [2,2,2,2,4, 4, 5,3,2,6,8], k = 8
O: ||||\=5

A1:Sliding Wondow
T: O(n)
S: O(1)

[2,2,2,2, 4, 4, 5,3,2,6,8], k = 8
l: 2
r: 3
cS: 0, 2,4,6,8|  12 - 2, -2 | 8+5.13-2.11
res:1| 2


*/
class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer, Integer> freq = new HashMap<>();
       freq.put(0, 1); // 
       int curr = 0, res = 0;

       for(int num: nums){
            curr += num;
            if( freq.containsKey(curr - k) ){
                res += freq.get(curr - k);
            }
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
       }
       return res;

    }
}