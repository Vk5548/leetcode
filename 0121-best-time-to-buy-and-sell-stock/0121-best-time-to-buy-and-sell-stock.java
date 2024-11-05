class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int bp = prices[0];
        int sp = prices[1];
        int diff = sp - bp;
        int maxDiff = diff;

        for(int i = 1; i < prices.length; i++){
            if(bp > prices[i] && i != prices.length -1){
                bp = prices[i];
                sp = prices[i+1];
            }else if(sp < prices[i]){
                sp = prices[i];
            }
            diff = sp - bp;
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff > 0 ? maxDiff : 0;
    }
}