/* 
int[n] nums, n- 2 elelmnets are specila numbers 
one of the remaining 2 elelmnets : is the sum of special numbers
and other is an outlier

outlier = not a special number and noth the sum of all of those special numbers
, the specila num  the sum ellement and the outlier have distinct indices but may not differ in value

Return the LARGEST potential outlier

CQ: 
1, can n be 0? what to return
2. what if n > 1?
3. is it guarnateed that the array will have at leats 3 numbers = [3, 3, 3];
4, Can answer be guranteed to be unique?
5. can numbers be -ve?
6. is teh array sorted?

I: [2,3,5,10]: [18, 17, 15, 10] : first the value has to be divisible by 2?
O: 10
n - 2: 2, 3
n - 1: sum = 5


I: [-2, -1, -3, -6, 4] -> [-6, -3, -2, -1, 4] => [-2, -5, -6, -7, -12] -> for any of this elelmnts if the value is twice the value present in the array, then we are sorted?

I2: [1,1,1,1,1,5,5] => [14, 14, 14, 14, 14, 10, 10]: 
O:

Q: Sorting and Prefix sum 

Hint: an array sum would be double of the sum number?, if we remove outlier fomr it?

-> Can we have our array : be reformed and the value at an index would represent , sum other than this ellemnt


A: calculate the fre of numbers, while calculating the sum and then in the next iteration for mn array, reducing the val from the sum 
and see if half the value is present in the map 


*/

class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        long totalSum = 0;
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            totalSum += num;
        } // got the fre and the sum
        int[] modifiedNums = new int[nums.length];
        int i = 0;
        int res = Integer.MIN_VALUE; 
        for(int x : nums){
            freq.put(x, freq.get(x) - 1); // temporarily remove outlier

            long remaining = totalSum - x; // 10
            if (remaining % 2 == 0){ // if even 
                int y = (int) remaining / 2;
                if(freq.getOrDefault(y, 0) > 0){
                    res = Math.max(res, x);
                }
            }
            freq.put(x, freq.get(x) + 1);
        }
        return res;

    }
}