
/* 
prices[i] 
, return the max maxProfit

[7, 1, 5, 3, 6, 4] -> 
A: 2 Pointers
profit -3, left++, 1 4 

A 1: brute firce: O(n2)
*/
class Solution {
    public int maxProfit(int[] prices) {
        int leftMin = Integer.MAX_VALUE;
        int maxDiff = -1;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < leftMin) leftMin = prices[i];
            maxDiff = Math.max(maxDiff, prices[i] - leftMin);
        }
        return maxDiff;
    }
}